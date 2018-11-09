package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivityRefundOrderCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivityRefundOrderUpdateRequest extends SportActivityRefundOrderCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
