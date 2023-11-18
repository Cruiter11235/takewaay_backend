package com.zjj.origod.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("token")
public class Token {
    @TableId("id")
    private int id;
    private int o_id;
    private int f_id;
    private int fcount;
}
