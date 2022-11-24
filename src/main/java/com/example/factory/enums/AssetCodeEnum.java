package com.example.factory.enums;

/**
 * @Author: super
 * @Date: 2022/8/12 11:20
 */
public enum AssetCodeEnum {
    MSP("MSP", "MSP"),
    USDT("USDT", "USDT"),
    MST("MST", "MST");

    private String code;
    private String name;

    AssetCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
