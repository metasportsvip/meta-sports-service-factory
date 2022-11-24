package com.example.factory.bean.po;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: super
 * @Date: 2022/11/24 9:49
 */
@Data
public class FactoryLockLog {
    private Integer id;
    private Long fid;
    private Long uid;
    private BigDecimal amount;
    private Long timestamp;
    private Integer type;
    private String createTime;
    private String updateTime;
}
