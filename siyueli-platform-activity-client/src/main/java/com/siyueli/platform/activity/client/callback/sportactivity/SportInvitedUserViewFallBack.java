package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportInvitedUserViewClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitedUserViewVo;
import org.springframework.stereotype.Component;

@Component
public class SportInvitedUserViewFallBack extends BaseServiceFallBack implements SportInvitedUserViewClient {
    @Override
    public ResponseData add(SportInvitedUserViewAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportInvitedUserViewUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportInvitedUserViewVo> get(SportInvitedUserViewGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportInvitedUserViewVo>> search(SportInvitedUserViewSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportInvitedUserViewDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
