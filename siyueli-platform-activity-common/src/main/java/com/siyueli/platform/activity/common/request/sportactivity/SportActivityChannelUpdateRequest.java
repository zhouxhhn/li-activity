package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivityChannelCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivityChannelUpdateRequest extends SportActivityChannelCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
