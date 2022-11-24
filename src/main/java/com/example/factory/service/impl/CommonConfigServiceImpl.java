package com.example.factory.service.impl;

import com.example.factory.bean.po.CommonConfig;
import com.example.factory.mapper.CommonConfigMapper;
import com.example.factory.service.CommonConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: super
 * @Date: 2022/8/8 18:52
 */
@Slf4j
@Service
public class CommonConfigServiceImpl implements CommonConfigService {
    @Resource
    private CommonConfigMapper commonConfigMapper;

    @Override
    public CommonConfig getInfoByKey(String key) {
        return commonConfigMapper.getInfoByKey(key);
    }

}
