package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivityViewStatisticsCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivityViewStatisticsUpdateRequest extends SportActivityViewStatisticsCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
