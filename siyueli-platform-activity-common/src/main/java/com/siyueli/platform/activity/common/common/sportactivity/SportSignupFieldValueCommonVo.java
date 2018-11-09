package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportSignupFieldValueCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("活动报名id")
    private Long signupId;

    @ApiModelProperty("字段id")
    private Long fieldId;

    @ApiModelProperty("字段值")
    private String fieldValue;

}
