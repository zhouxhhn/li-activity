package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivityOrderCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivityOrderUpdateRequest extends SportActivityOrderCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
