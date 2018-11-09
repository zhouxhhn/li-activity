package com.siyueli.platform.activity.client.callback.sportmemberfavorites;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportmemberfavorites.SportMemberFavoritesClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportmemberfavorites.*;
import com.siyueli.platform.activity.common.response.sportmemberfavorites.SportMemberFavoritesVo;
import org.springframework.stereotype.Component;

@Component
public class SportMemberFavoritesFallBack extends BaseServiceFallBack implements SportMemberFavoritesClient {
    @Override
    public ResponseData add(SportMemberFavoritesAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportMemberFavoritesUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportMemberFavoritesVo> get(SportMemberFavoritesGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportMemberFavoritesVo>> search(SportMemberFavoritesSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportMemberFavoritesDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
