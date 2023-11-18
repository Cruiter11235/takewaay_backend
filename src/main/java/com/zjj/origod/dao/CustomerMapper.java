package com.zjj.origod.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjj.origod.pojo.Admin;
import com.zjj.origod.pojo.Customer;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CustomerMapper{
    Customer selectByUsername(@Param("username")String username);

    void insertCustomer(@Param("name")String name,@Param("username")String username,@Param("password")String password);
}
