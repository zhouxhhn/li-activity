package com.siyueli.platform.activity.common.request.customform;

import com.siyueli.platform.activity.common.common.customform.CustomFormFieldRelationshipCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomFormFieldRelationshipUpdateRequest extends CustomFormFieldRelationshipCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
