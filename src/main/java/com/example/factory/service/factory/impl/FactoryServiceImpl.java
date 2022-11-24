package com.example.factory.service.factory.impl;

import com.example.factory.bean.po.Factory;
import com.example.factory.mapper.FactoryMapper;
import com.example.factory.service.factory.FactoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: super
 * @Date: 2022/11/24 9:55
 */
@Slf4j
@Service
public class FactoryServiceImpl implements FactoryService {
    @Resource
    private FactoryMapper factoryMapper;

    @Override
    public List<Factory> listByStatus(Integer status) {
        return factoryMapper.listByStatus(status);
    }
}
