package com.example.factory.mapper;

import com.example.factory.bean.po.Factory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: super
 * @Date: 2022/11/24 9:58
 */
@Mapper
public interface FactoryMapper {
    List<Factory> listByStatus(@Param("status") Integer status);
}
