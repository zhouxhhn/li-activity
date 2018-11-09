package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivitySponsorClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivitySponsorVo;
import org.springframework.stereotype.Component;

@Component
public class SportActivitySponsorFallBack extends BaseServiceFallBack implements SportActivitySponsorClient {
    @Override
    public ResponseData add(SportActivitySponsorAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportActivitySponsorUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportActivitySponsorVo> get(SportActivitySponsorGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportActivitySponsorVo>> search(SportActivitySponsorSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportActivitySponsorDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
