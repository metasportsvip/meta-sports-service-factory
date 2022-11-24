package com.example.factory.mapper;

import com.example.factory.bean.po.FactoryProfitClaim;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author: super
 * @Date: 2022/11/24 9:58
 */
@Mapper
public interface FactoryProfitClaimMapper {
    void create(@Param("fid") Long fid, @Param("uid") Long uid);

    FactoryProfitClaim infoByForUpdate(@Param("fid") Long fid, @Param("uid") Long uid);

    void updateProfit(@Param("fid") Long fid, @Param("uid") Long uid, @Param("amount") BigDecimal amount);
}
