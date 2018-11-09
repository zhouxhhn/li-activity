package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportActivityCategoryCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportActivityCategoryUpdateRequest extends SportActivityCategoryCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
