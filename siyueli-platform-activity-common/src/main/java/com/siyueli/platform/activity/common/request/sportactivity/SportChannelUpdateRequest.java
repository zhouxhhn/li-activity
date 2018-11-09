package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportChannelCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportChannelUpdateRequest extends SportChannelCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
