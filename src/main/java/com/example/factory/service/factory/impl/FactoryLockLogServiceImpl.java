package com.example.factory.service.factory.impl;

import com.example.factory.bean.po.FactoryLockLog;
import com.example.factory.mapper.FactoryLockLogMapper;
import com.example.factory.service.factory.FactoryLockLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: super
 * @Date: 2022/11/24 9:57
 */
@Slf4j
@Service
public class FactoryLockLogServiceImpl implements FactoryLockLogService {
    @Resource
    private FactoryLockLogMapper factoryLockLogMapper;

    @Override
    public void insert(FactoryLockLog factoryLockLog) {
        factoryLockLogMapper.insert(factoryLockLog);
    }
}
