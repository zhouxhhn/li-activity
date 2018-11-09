package com.siyueli.platform.activity.common.response.customform;

import com.siyueli.platform.activity.common.common.customform.CustomFormFieldRelationshipCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CustomFormFieldRelationshipVo extends CustomFormFieldRelationshipCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("更新时间")
    private Date updateAt;

    @ApiModelProperty("创建时间")
    private Date createAt;

}
