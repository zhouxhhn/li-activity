package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivityCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivityUpdateRequest extends SportActivityCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
