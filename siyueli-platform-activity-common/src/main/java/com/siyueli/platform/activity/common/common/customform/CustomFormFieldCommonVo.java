package com.siyueli.platform.activity.common.common.customform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomFormFieldCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("字段名")
    private String fieldName;

    @ApiModelProperty("校验规则")
    private String validateRegular;

    @ApiModelProperty("字段类型")
    private Integer fieldType;

    @ApiModelProperty("是否必填")
    private Integer required;

}
