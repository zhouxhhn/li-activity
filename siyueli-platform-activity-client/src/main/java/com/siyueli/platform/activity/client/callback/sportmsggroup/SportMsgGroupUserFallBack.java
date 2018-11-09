package com.siyueli.platform.activity.client.callback.sportmsggroup;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportmsggroup.SportMsgGroupUserClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportmsggroup.*;
import com.siyueli.platform.activity.common.response.sportmsggroup.SportMsgGroupUserVo;
import org.springframework.stereotype.Component;

@Component
public class SportMsgGroupUserFallBack extends BaseServiceFallBack implements SportMsgGroupUserClient {
    @Override
    public ResponseData add(SportMsgGroupUserAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportMsgGroupUserUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportMsgGroupUserVo> get(SportMsgGroupUserGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportMsgGroupUserVo>> search(SportMsgGroupUserSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportMsgGroupUserDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
