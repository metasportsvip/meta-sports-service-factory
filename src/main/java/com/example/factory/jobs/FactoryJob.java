package com.example.factory.jobs;


import com.example.factory.bean.bo.ProfitClaimUpdateBO;
import com.example.factory.bean.po.*;
import com.example.factory.config.SystemConfig;
import com.example.factory.service.CommonConfigService;
import com.example.factory.service.EmailService;
import com.example.factory.service.factory.FactoryProfitClaimService;
import com.example.factory.service.factory.FactoryService;
import com.example.factory.utils.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * FactoryJob
 *
 * @author cc
 */
@Slf4j
@Component
@Configuration
public class FactoryJob {
    @Resource
    private FactoryService factoryService;
    @Resource
    private FactoryProfitClaimService factoryProfitClaimService;
    @Resource
    private CommonConfigService commonConfigService;
    @Resource
    private EmailService emailService;

    @Value("${spring.profiles.active}")
    private String active;

    /**
     * 能量工厂Map
     */
    List<Factory> factoryList = new ArrayList<>();

    /**
     * 收益产出
     */
    List<ProfitClaimUpdateBO> profitClaimUpdateBOS = new ArrayList<>();

    // 日期
    Long date = null;
    Long currentUnixTime = null;
    // 产出比
    BigDecimal profit_rate = null;
    BigDecimal MST_USDT = null;

    @Scheduled(cron = "0/3 * * * * ?")
    private void factory() {
        log.info("factory:3s/c  FactoryJob********start");
        try {
            initData();
            processing();
            execute();
            clear();
        } catch (Exception e) {
            clear();
            if (active.equals("prod")) {
                String content = "【MS_PORTS】FactoryJobWarning:" + e.getMessage();
                String subject = "Factory warning";
                emailService.sendWarning("2366262485@qq.com", subject, content);
            }
            e.printStackTrace();
            log.error("FactoryJobError - " + e.getMessage());
        }
        log.info("factory:3s/c  FactoryJob********end");
    }

    public void initData() {
        date = Common.getCurrentDay();
        currentUnixTime = Common.currentUnixTime();
        factoryList = factoryService.listByStatus(0);
        profit_rate = new BigDecimal(commonConfigService.getInfoByKey(SystemConfig.KEY_FACTORY_PROFIT_RATE).getValue());
        MST_USDT = new BigDecimal(commonConfigService.getInfoByKey(SystemConfig.KEY_MST_USDT_PRICE).getValue());
    }
    public void processing() {
        if (factoryList.size() == 0) {
            log.info("无能量工厂");
            return;
        }
        factoryList.forEach(factory -> {
            Long fid = factory.getFid();
            Long uid = factory.getUid();
            if (factory.getAmountLock().compareTo(BigDecimal.ZERO) > 0 && currentUnixTime <= factory.getExpireTime()) {
                BigDecimal profit = factory.getAmountLock().multiply(profit_rate).multiply(MST_USDT);
                ProfitClaimUpdateBO profitClaimUpdate = new ProfitClaimUpdateBO();
                profitClaimUpdate.setFid(fid);
                profitClaimUpdate.setUid(uid);
                profitClaimUpdate.setAmount(profit);
                profitClaimUpdateBOS.add(profitClaimUpdate);
            } else {
                log.info("fid:{}, 未质押MST或者已到期不产出", fid);
            }
        });
    }
    public void execute() {
        if (profitClaimUpdateBOS.size() == 0) {
            log.info("无产出收益");
            return;
        }
        factoryProfitClaimService.addProfitAll(profitClaimUpdateBOS);
    }
    public void clear() {
        factoryList.clear();
        profitClaimUpdateBOS.clear();
        date = null;
        currentUnixTime = null;
    }
}
