package com.example.factory.mapper;

import com.example.factory.bean.po.CommonConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: super
 * @Date: 2022/8/8 18:46
 */
@Mapper
public interface CommonConfigMapper {

    CommonConfig getInfoByKey(@Param("key") String key);

}
