package com.siyueli.platform.activity.common.request.sportactivity;

import com.siyueli.platform.activity.common.common.sportactivity.SportInvitationLetterCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportInvitationLetterUpdateRequest extends SportInvitationLetterCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
