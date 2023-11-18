package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@TableName("admin_table")
public class Admin {
    @TableId("m_id")
    private int a_id;
    private String a_username;
    private String a_password;

}
