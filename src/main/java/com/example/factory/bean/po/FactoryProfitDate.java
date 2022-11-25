package com.example.factory.bean.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: super
 * @Date: 2022/8/17 16:25
 */
@Data
public class FactoryProfitDate {
    private Long id;
    private Long uid;
    private Long fid;
    private Long date;
    private BigDecimal profit;
    private String createTime;
    private String updateTime;
}
