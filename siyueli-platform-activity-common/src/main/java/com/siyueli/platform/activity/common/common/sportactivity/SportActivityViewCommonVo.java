package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportActivityViewCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("活动id")
    private Long activityId;

    @ApiModelProperty("活动渠道id")
    private Long activityChannelId;

}
