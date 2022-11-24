package com.example.factory.service.factory;

import com.example.factory.bean.bo.ProfitClaimUpdateBO;
import com.example.factory.bean.po.FactoryProfitClaim;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: super
 * @Date: 2022/11/24 9:55
 */
public interface FactoryProfitClaimService {
    FactoryProfitClaim infoForUpdate(Long uid, Long fid);

    void updateProfit(Long fig, Long uid, BigDecimal amount);

    void addProfitAll(List<ProfitClaimUpdateBO> profitClaimUpdateList);
}
