package com.siyueli.platform.activity.common.common.sportmemberfavorites;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SportMemberFavoritesCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("实体id")
    private Long entityId;

    @ApiModelProperty("收藏活动的类型")
    private Integer type;

}
