package com.example.factory.bean.bo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: super
 * @Date: 2022/10/8 14:33
 */
@Data
public class ProfitClaimUpdateBO {
    private Long uid;
    private Long fid;
    private BigDecimal amount;
}
