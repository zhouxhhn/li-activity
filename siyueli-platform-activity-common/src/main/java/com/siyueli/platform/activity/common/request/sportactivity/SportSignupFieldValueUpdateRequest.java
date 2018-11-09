package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportSignupFieldValueCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportSignupFieldValueUpdateRequest extends SportSignupFieldValueCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
