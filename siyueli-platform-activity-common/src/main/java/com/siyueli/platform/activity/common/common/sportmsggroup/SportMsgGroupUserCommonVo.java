package com.siyueli.platform.activity.common.common.sportmsggroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportMsgGroupUserCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分组id")
    private Long groupId;

    @ApiModelProperty("用户id")
    private Long userId;

}
