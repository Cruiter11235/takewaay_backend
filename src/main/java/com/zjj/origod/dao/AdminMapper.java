package com.zjj.origod.dao;

import com.zjj.origod.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMapper {
    Admin selectByUsername(@Param("username") String username);
}
