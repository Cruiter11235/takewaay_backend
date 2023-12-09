package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("report_table")
public class Report {
    @TableId("r_d")
    private int r_id;
    private String content;
    private int m_id;
    private int c_id;
    private int solved;
}
