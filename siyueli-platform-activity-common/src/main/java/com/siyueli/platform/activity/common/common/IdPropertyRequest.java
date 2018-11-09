package com.siyueli.platform.activity.common.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IdPropertyRequest {

    @NotNull(message = "id不能为空")
    @ApiModelProperty("id")
    private Long id;
}
