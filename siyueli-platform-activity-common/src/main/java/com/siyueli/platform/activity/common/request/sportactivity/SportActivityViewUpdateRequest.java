package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivityViewCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivityViewUpdateRequest extends SportActivityViewCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
