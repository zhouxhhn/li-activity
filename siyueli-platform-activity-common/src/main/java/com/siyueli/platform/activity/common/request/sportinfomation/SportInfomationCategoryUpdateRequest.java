package com.siyueli.platform.activity.common.request.sportinfomation;

import com.siyueli.platform.activity.common.common.sportinformation.SportInfomationCategoryCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportInfomationCategoryUpdateRequest extends SportInfomationCategoryCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
