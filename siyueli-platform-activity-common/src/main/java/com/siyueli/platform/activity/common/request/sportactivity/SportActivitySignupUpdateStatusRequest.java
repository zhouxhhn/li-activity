package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.IdPropertyRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivitySignupUpdateStatusRequest extends IdPropertyRequest {

    @ApiModelProperty("状态: 待审核-10，成功-20，取消-30，拒绝-40")
    private Integer status;
}
