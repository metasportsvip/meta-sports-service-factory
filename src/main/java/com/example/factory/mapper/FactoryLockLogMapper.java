package com.example.factory.mapper;

import com.example.factory.bean.po.FactoryLockLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: super
 * @Date: 2022/11/24 9:58
 */
@Mapper
public interface FactoryLockLogMapper {
    void insert(FactoryLockLog factoryLockLog);
}
