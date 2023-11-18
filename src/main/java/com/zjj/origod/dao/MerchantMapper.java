package com.zjj.origod.dao;

import com.zjj.origod.pojo.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MerchantMapper {
    Merchant selectByUsername(@Param("username")String username);

    void insertMerchant(@Param("name")String name,@Param("username")String username,@Param("password")String password);
}
