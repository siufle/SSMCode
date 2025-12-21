package com.xq.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user") //将数据库表名与当前类形成映射
public class User {

    @TableId(value = "uid",type = IdType.AUTO)//表明当前属性是主键 并采用自增长的策略
    private Long uid;

    @TableField("name") //将当前实体类中的属性与数据表中的字段形成映射
    private String userName;

    private Integer age;

    private String email;

    @TableLogic //表示当前字段是逻辑删除字段
    private int isDeleted;

    private SexEnum sex;
}
