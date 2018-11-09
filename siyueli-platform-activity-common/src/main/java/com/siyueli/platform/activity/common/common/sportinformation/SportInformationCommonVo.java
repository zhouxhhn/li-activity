package com.siyueli.platform.activity.common.common.sportinformation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportInformationCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章简介")
    private String introduction;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("是否热门文章")
    private Integer isHot;

    @ApiModelProperty("文章详情")
    private String details;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("封面图id")
    private Long imageId;

    @ApiModelProperty("封面图url")
    private String imageUrl;

}
