package com.siyueli.platform.activity.common.request.sportmemberfavorites;

import com.siyueli.platform.activity.common.common.sportmemberfavorites.SportMemberFavoritesCommonVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SportMemberFavoritesUpdateRequest extends SportMemberFavoritesCommonVo {

    @ApiModelProperty("主键")
    private Long id;
}
