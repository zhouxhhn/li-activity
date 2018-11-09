package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportActivitySponsorCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主办方名称")
    private String name;

    @ApiModelProperty("联系电话")
    private String telephone;

    @ApiModelProperty("联系邮箱")
    private String email;

    @ApiModelProperty("官方网址")
    private String website;

    @ApiModelProperty("主办方介绍")
    private String introduction;

    @ApiModelProperty("主办方logo图片id")
    private Long logoImageId;

    @ApiModelProperty("主办方logo图片url")
    private String logoImageUrl;

}
