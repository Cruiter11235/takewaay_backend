package com.zjj.origod.dao;

import com.zjj.origod.pojo.Delivery;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DeliveryMapper {
    Delivery selectByUsername(@Param("username") String username);

    void insertDelivery(@Param("d")Delivery delivery);

    void updateDeliveryById(
            @Param("d_id")int d_id,
            @Param("d_password")String d_password,
            @Param("d_phone")String d_phone
    );

    void UpdateOrder(
            @Param("o_id")int o_id,
            @Param("d_id")int d_id,
            @Param("begin_time")String begin_time
    );

    @MapKey("o_id")
    List<Map<String,Object>> selectAccessibleOrder();


    @MapKey("o_id")
    List<Map<String,Object>> selectOrderByD_id(
            @Param("d_id")int d_id
    );


    @MapKey("id")
    List<Map<String,Object>> selectFoodInOrder(@Param("o_id")int o_id);


    Delivery getInfo(@Param("d_id")int d_id);

    void updateInfo(@Param("d")Delivery delivery);
}
