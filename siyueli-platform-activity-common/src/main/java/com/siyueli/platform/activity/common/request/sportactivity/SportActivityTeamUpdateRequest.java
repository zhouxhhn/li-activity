package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivityTeamCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivityTeamUpdateRequest extends SportActivityTeamCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
