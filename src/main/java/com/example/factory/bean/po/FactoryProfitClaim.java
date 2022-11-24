package com.example.factory.bean.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: super
 * @Date: 2022/8/17 16:25
 */
@Data
public class FactoryProfitClaim {
    private Long id;
    private Long uid;
    private Long fid;
    private BigDecimal unclaimedProfit;
    private BigDecimal cumulativeProfit;
    private String createTime;
    private String updateTime;
}
