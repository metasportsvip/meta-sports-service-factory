package com.example.factory.service.factory.impl;

import com.example.factory.bean.bo.ProfitClaimUpdateBO;
import com.example.factory.bean.po.FactoryProfitClaim;
import com.example.factory.bean.po.FactoryProfitDate;
import com.example.factory.mapper.FactoryProfitClaimMapper;
import com.example.factory.service.factory.FactoryProfitClaimService;
import com.example.factory.utils.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: super
 * @Date: 2022/11/24 9:58
 */
@Slf4j
@Service
public class FactoryProfitClaimServiceImpl implements FactoryProfitClaimService {
    @Resource
    private FactoryProfitClaimMapper factoryProfitClaimMapper;

    @Override
    public FactoryProfitClaim infoForUpdate(Long fid, Long uid) {
        FactoryProfitClaim info = factoryProfitClaimMapper.infoByForUpdate(fid, uid);
        if (null == info) {
            factoryProfitClaimMapper.create(fid, uid);
            info = factoryProfitClaimMapper.infoByForUpdate(fid, uid);
        }
        return info;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProfit(Long fid, Long uid, BigDecimal amount) {
        infoForUpdate(fid, uid);
        factoryProfitClaimMapper.updateProfit(fid, uid, amount);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void profitEx(List<ProfitClaimUpdateBO> profitClaimUpdateList) {
        addProfitAll(profitClaimUpdateList);
        addDateProfit(profitClaimUpdateList);
    }

    @Override
    public void addProfitAll(List<ProfitClaimUpdateBO> profitClaimUpdateList) {
        for (ProfitClaimUpdateBO profitClaimUpdate : profitClaimUpdateList) {
            Long uid = profitClaimUpdate.getUid();
            Long fid = profitClaimUpdate.getFid();
            BigDecimal amount = profitClaimUpdate.getAmount();
            updateProfit(fid, uid, amount);
        }
    }

    @Override
    public void addDateProfit(List<ProfitClaimUpdateBO> profitClaimUpdateList) {
        List<FactoryProfitDate> insertList = new ArrayList<>();
        List<FactoryProfitDate> updateList = new ArrayList<>();
        Long date = Common.getCurrentDay();
        List<FactoryProfitDate> factoryProfitDateS = factoryProfitClaimMapper.factoryProjectDateList(date);
        Map<String, FactoryProfitDate> profitDateMap = new HashMap<>();
        factoryProfitDateS.forEach(factoryProfitDate -> profitDateMap.put(factoryProfitDate.getFid() + "_" + factoryProfitDate.getUid() + "_" + factoryProfitDate.getDate(), factoryProfitDate));
        for (ProfitClaimUpdateBO profitClaimUpdate : profitClaimUpdateList) {
            Long uid = profitClaimUpdate.getUid();
            Long fid = profitClaimUpdate.getFid();
            BigDecimal amount = profitClaimUpdate.getAmount();
            FactoryProfitDate factoryProfitDate = new FactoryProfitDate();
            factoryProfitDate.setFid(fid);
            factoryProfitDate.setUid(uid);
            factoryProfitDate.setDate(date);
            factoryProfitDate.setProfit(amount);
            String key = fid + "_" +  uid + "_" + date;
            if (profitDateMap.containsKey(key)) {
                updateList.add(factoryProfitDate);
            } else {
                insertList.add(factoryProfitDate);
            }
        }
        if (insertList.size() > 0) factoryProfitClaimMapper.insertDateProfit(insertList);
        if (updateList.size() > 0) factoryProfitClaimMapper.updateDateProfit(updateList);
    }
}
