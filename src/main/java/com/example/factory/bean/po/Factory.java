package com.example.factory.bean.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: super
 * @Date: 2022/11/24 9:49
 */
@Data
public class Factory {
    private Long fid;
    private Long uid;
    private String name;
    private BigDecimal amountLock;
    private Long expireTime;
    private Integer status;
    private String createTime;
    private String updateTime;
}
