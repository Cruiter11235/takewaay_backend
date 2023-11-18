package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("food_table")
public class Food {
    @TableId("f_id")
    private int f_id;
    private int m_id;
    private int class_id;
    private String f_name;
    private boolean is_avaiable;
    private int sale_count;
    private double score;
    private String f_url;
    private double f_price;
}
