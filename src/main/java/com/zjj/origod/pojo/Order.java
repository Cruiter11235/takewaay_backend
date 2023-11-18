package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("order_table")
public class Order {
    @TableId("o_id")
    private int o_id;
    private int m_id;
    private int c_id;
    private int d_id;
    private Date begin_time;
    private String status;
}
