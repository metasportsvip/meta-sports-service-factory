package com.example.factory.config;

import java.math.BigDecimal;

/**
 * @Author: super
 * @Date: 2022/8/16 14:59
 */
public class SystemConfig {
    // 能量工厂锁仓日产出比
    public static String KEY_FACTORY_PROFIT_RATE = "FACTORY_PROFIT_RATE";
    // MST_USDT_PRICE
    public static String KEY_MST_USDT_PRICE = "MST_USDT_PRICE";
    // 每日产出次数
    public static BigDecimal TOTAL_FACTORY_PROFIT_TIMES = new BigDecimal("28800");
}
