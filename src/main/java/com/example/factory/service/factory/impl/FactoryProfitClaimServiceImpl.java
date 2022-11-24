package com.example.factory.service.factory.impl;

import com.example.factory.bean.bo.ProfitClaimUpdateBO;
import com.example.factory.bean.po.FactoryProfitClaim;
import com.example.factory.mapper.FactoryProfitClaimMapper;
import com.example.factory.service.factory.FactoryProfitClaimService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

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
    public FactoryProfitClaim infoForUpdate(Long uid, Long fid) {
        FactoryProfitClaim info = factoryProfitClaimMapper.infoByForUpdate(uid, fid);
        if (null == info) {
            factoryProfitClaimMapper.create(fid, uid);
            info = factoryProfitClaimMapper.infoByForUpdate(uid, fid);
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
    public void addProfitAll(List<ProfitClaimUpdateBO> profitClaimUpdateList) {
        for (ProfitClaimUpdateBO profitClaimUpdate : profitClaimUpdateList) {
            Long uid = profitClaimUpdate.getUid();
            Long fid = profitClaimUpdate.getFid();
            BigDecimal amount = profitClaimUpdate.getAmount();
            updateProfit(fid, uid, amount);
        }
    }
}
