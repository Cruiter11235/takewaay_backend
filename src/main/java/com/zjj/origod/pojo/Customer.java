package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@TableName("customer_table")
public class Customer {
    @TableId("c_id")
    private int c_id;
    private String c_name;
    private String c_username;
    private String c_password;
    private String c_phone;
    private String c_address;
}
