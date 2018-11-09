package com.siyueli.platform.activity.common.common.sportactivity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportInfomationCategoryCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父级id")
    private Long parentId;

    @ApiModelProperty("最左")
    private Integer lft;

    @ApiModelProperty("最右")
    private Integer rgt;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("是否已删除")
    private Integer isDeleted;

    @ApiModelProperty("分类简介")
    private String introduction;

}
