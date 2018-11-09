package com.siyueli.platform.activity.common.request.activitywindow.actwinplate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateActWinPlateRequest extends ActWinPlateCommonRequest {

    @ApiModelProperty("id")
    private Long id;
}
