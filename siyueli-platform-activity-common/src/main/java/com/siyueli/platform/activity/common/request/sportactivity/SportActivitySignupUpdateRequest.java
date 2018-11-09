package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivitySignupCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivitySignupUpdateRequest extends SportActivitySignupCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
