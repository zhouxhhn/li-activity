package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.IdPropertyRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivityChannelUpdateStatusRequest extends IdPropertyRequest {

    @ApiModelProperty("1-开启，0-关闭")
    private Integer status;
}
