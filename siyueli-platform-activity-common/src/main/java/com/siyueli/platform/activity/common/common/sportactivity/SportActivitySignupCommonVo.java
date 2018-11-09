package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportActivitySignupCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("活动id")
    private Long activityId;

    @ApiModelProperty("活动渠道id")
    private Long activityChannelId;

    /*@ApiModelProperty("队伍id")
    private Long teamId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("状态")
    private Integer status;*/

    /*@ApiModelProperty("是否已删除")
    private Integer isDeleted;*/

}
