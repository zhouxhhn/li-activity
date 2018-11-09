package com.siyueli.platform.activity.client.callback.sportmsggroup;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportmsggroup.SportMsgGroupClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportmsggroup.*;
import com.siyueli.platform.activity.common.response.sportmsggroup.SportMsgGroupVo;
import org.springframework.stereotype.Component;

@Component
public class SportMsgGroupFallBack extends BaseServiceFallBack implements SportMsgGroupClient {
    @Override
    public ResponseData add(SportMsgGroupAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportMsgGroupUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportMsgGroupVo> get(SportMsgGroupGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportMsgGroupVo>> search(SportMsgGroupSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportMsgGroupDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
