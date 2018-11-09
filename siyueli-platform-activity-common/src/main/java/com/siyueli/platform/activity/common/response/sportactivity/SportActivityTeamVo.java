package com.siyueli.platform.activity.common.response.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivityTeamCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SportActivityTeamVo extends SportActivityTeamCommonVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("创建时间")
    private Date createAt;

    @ApiModelProperty("更新时间")
    private Date updateAt;

}
