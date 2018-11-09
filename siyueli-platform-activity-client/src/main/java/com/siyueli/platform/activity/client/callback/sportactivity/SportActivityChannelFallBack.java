package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityChannelClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityChannelVo;
import org.springframework.stereotype.Component;

@Component
public class SportActivityChannelFallBack extends BaseServiceFallBack implements SportActivityChannelClient {
    @Override
    public ResponseData add(SportActivityChannelAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportActivityChannelUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportActivityChannelVo> get(SportActivityChannelGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportActivityChannelVo>> search(SportActivityChannelSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportActivityChannelDeleteRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData updateStatus(SportActivityChannelUpdateStatusRequest requestParam) {
        return getDownGradeResponse();
    }
}
