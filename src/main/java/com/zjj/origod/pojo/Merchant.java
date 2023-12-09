package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@TableName("merchant_table")
public class Merchant {
    @TableId("m_id")
    private int m_id;
    private String m_name;
    private String m_username;
    private String m_password;
    private String m_address;
    private String m_phone;
    private int locked;
}
