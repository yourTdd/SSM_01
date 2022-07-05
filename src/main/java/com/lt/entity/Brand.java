package com.lt.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("tb_brand")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("brand_name")
    private String brandName;
    @TableField("company_name")
    private String companyName;
    private Integer ordered;
    private String description;
    private Integer status;
    @TableLogic(value = "0",delval = "1")
    @TableField(select = false)
    private Integer deleted;
}
