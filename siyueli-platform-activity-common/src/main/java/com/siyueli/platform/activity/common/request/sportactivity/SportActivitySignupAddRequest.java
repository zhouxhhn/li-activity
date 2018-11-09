package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivitySignupCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivitySignupAddRequest extends SportActivitySignupCommonVo {

    @ApiModelProperty("邀请函id")
    private Long letterId;
}
