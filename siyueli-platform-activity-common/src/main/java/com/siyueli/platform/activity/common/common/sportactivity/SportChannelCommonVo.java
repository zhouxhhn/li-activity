package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportChannelCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("渠道名称")
    private String name;

    @ApiModelProperty("渠道标记")
    private String flag;

    @ApiModelProperty("渠道介绍")
    private String introduction;

}
