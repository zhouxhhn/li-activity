package com.siyueli.platform.activity.common.request.sportmsggroup;

import com.siyueli.platform.activity.common.common.sportmsggroup.SportMsgGroupUserCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportMsgGroupUserUpdateRequest extends SportMsgGroupUserCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
