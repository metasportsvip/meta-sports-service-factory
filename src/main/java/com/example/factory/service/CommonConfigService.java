package com.example.factory.service;

import com.example.factory.bean.po.CommonConfig;

/**
 * @Author: super
 * @Date: 2022/8/8 18:52
 */
public interface CommonConfigService {
    CommonConfig getInfoByKey(String key);
}
