package com.zjj.origod.dao;

import com.zjj.origod.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminMapper {
    Report getReportById(@Param("r_id")int r_id);
    Admin selectByUsername(@Param("username") String username);
    List<Merchant>  selectMerchant();
    List<Customer> selectCustomers();
    List<Delivery> selectDelivery();
    List<Food> selectFood();
    List<Order> selectOrder();
    List<FoodClass> selectClass();
    List<Report> selectReports();

    void deleteMerchant(@Param("m_id")int m_id);

    void deleteCustomer(@Param("c_id")int c_id);

    void deleteDelivery(@Param("d_id")int d_id);

    void updateCustomer(@Param("new_password")String password,@Param("c_id")int c_id);

    void updateDelivery(@Param("new_password")String password,@Param("d_id")int d_id);

    void updateReport(@Param("r_id")int r_id);

    void LockMerchant(@Param("m_id")int m_id);

    void UnLockMerchant(@Param("m_id")int m_id);

    void updateMerchant(
            @Param("m_id")int m_id,
            @Param("m_name")String m_name,
            @Param("m_password")String m_password,
            @Param("m_phone")String m_phone,
            @Param("m_address")String m_address
    );

    void createMerchant(
            @Param("m_name")String m_name,
            @Param("m_username")String m_username,
            @Param("m_password")String m_password,
            @Param("m_address")String m_address,
            @Param("m_phone")String m_phone
    );
}
