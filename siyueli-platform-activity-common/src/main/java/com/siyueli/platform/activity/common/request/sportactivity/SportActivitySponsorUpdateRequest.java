package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivitySponsorCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivitySponsorUpdateRequest extends SportActivitySponsorCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
