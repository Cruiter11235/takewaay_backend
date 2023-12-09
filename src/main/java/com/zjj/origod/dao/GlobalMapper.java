package com.zjj.origod.dao;

import com.zjj.origod.pojo.Customer;
import com.zjj.origod.pojo.Order;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GlobalMapper {
//    Merchant
    @MapKey("f_id")
    List<Map<String,Object>> selectFoodByM_id(@Param("m_id")int m_id);

    void updateFoodById(
            @Param("f_id")int f_id,
            @Param("class_id")int class_id,
            @Param("f_name")String f_name,
            @Param("is_available")int is_available,
            @Param("f_price")double f_price
    );

    void insertFoodOnM_id(
            @Param("m_id")int m_id,
            @Param("class_id")int class_id,
            @Param("f_name")String name,
            @Param("is_available")int is_available,
            @Param("f_price")double f_price
    );


    void deleteFoodById(
            @Param("f_id")int f_id
    );


    @MapKey("o_id")
    List<Map<String,Object>> selectOrderByM_id(
            @Param("m_id")int m_id
    );

    void updateOrderStatusById(
            @Param("o_id")int o_id,
            @Param("status")String status
    );


    @MapKey("id")
    List<Map<String,Object>> selectFoodsByOrder(
            @Param("o_id")int o_id
    );


    @MapKey("comment_id")
    List<Map<String,Object>> selectCommentByM_id(
            @Param("m_id")int m_id
    );


    void insertOrder(@Param("order")Order order);


    void insertFoodInOrder(@Param("o_id")int o_id,@Param("f_id")int f_id,@Param("f_count")int f_count);
}

