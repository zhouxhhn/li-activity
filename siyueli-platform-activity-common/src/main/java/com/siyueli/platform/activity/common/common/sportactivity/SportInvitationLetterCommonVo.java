package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportInvitationLetterCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("邀请用户id")
    private Long userId;

    @ApiModelProperty("活动id")
    private Long activityId;

}
