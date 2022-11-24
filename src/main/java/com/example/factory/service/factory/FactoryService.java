package com.example.factory.service.factory;

import com.example.factory.bean.po.Factory;

import java.util.List;

/**
 * @Author: super
 * @Date: 2022/11/24 9:55
 */
public interface FactoryService {
    List<Factory> listByStatus(Integer status);
}
