package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName("order_table")
public class Order {
    @TableId("o_id")
    private int o_id;

    @TableField("m_id")
    private int m_id;

    @TableField("c_id")
    private int c_id;

    @TableField("d_id")
    private int d_id;

    @TableField("begin_time")
    private Timestamp begin_time;

    @TableField("status")
    private String status;
}
