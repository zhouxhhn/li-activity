package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportChannelClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportChannelVo;
import org.springframework.stereotype.Component;

@Component
public class SportChannelFallBack extends BaseServiceFallBack implements SportChannelClient {
    @Override
    public ResponseData add(SportChannelAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportChannelUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportChannelVo> get(SportChannelGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportChannelVo>> search(SportChannelSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportChannelDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
