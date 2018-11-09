package com.siyueli.platform.activity.common.response.activitywindow;

import com.siyueli.platform.activity.common.common.activitywindow.ActWinPlateCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ActWinPlateVo extends ActWinPlateCommonVo {

    @ApiModelProperty("id")
    private Long id;

    /**
     * 状态
     */
    @ApiModelProperty("状态: 1-启用，0-禁用")
    private Integer status;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createAt;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateAt;
}
