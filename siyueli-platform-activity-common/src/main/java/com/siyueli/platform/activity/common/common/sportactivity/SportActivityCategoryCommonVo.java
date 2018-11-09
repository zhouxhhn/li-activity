package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportActivityCategoryCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("父级id")
    private Long parentId;

    /*@ApiModelProperty("最左")
    private Integer lft;

    @ApiModelProperty("最右")
    private Integer rgt;*/

    @ApiModelProperty("排序")
    private Integer sort;

    /*@ApiModelProperty("是否已删除")
    private Integer isDeleted;*/

    @ApiModelProperty("分类简介")
    private String introduction;

    @ApiModelProperty("分类id")
    private Long imageId;

    @ApiModelProperty("分类url")
    private String imageUrl;

    @ApiModelProperty("是否设为热门分类")
    private Integer isHot;

}
