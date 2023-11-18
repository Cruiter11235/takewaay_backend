package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@TableName("comment_table")
public class Comment {
    @TableId("f_id")
    private int f_id;
    private int comment_id;
    private String content;
    private double score;
}
