package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportInvitedUserViewCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("邀请函id")
    private Long letterId;

}
