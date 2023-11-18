package com.zjj.origod.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class FoodClass {
    @TableId("class_id")
    private int class_id;
    private String class_name;
}
