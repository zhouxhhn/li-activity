package com.siyueli.platform.activity.common.request.sportinfomation;

import com.siyueli.platform.activity.common.common.sportinformation.SportInformationCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportInformationUpdateRequest extends SportInformationCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
