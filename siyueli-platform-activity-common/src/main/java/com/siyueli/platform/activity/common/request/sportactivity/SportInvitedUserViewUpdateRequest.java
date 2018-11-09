package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportInvitedUserViewCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportInvitedUserViewUpdateRequest extends SportInvitedUserViewCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
