package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("delivery_table")
public class Delivery {
    @TableId("d_id")
    private int d_id;
    private String d_username;
    private String d_password;
    private String d_phone;
}
