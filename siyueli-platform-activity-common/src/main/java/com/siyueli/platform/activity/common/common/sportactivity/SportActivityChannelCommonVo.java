package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportActivityChannelCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("活动id")
    private Long activityId;

    @ApiModelProperty("渠道id")
    private Long channelId;

    @ApiModelProperty("渠道链接")
    private String linkUrl;

    @ApiModelProperty("渠道状态")
    private Integer status;

}
