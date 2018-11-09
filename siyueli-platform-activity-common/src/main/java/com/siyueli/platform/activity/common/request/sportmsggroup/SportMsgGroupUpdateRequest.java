package com.siyueli.platform.activity.common.request.sportmsggroup;

import com.siyueli.platform.activity.common.common.sportmsggroup.SportMsgGroupCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportMsgGroupUpdateRequest extends SportMsgGroupCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
