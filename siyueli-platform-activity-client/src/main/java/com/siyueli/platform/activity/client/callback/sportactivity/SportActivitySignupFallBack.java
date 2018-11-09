package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivitySignupClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivitySignupVo;
import org.springframework.stereotype.Component;

@Component
public class SportActivitySignupFallBack extends BaseServiceFallBack implements SportActivitySignupClient {
    @Override
    public ResponseData add(SportActivitySignupAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportActivitySignupUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportActivitySignupVo> get(SportActivitySignupGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportActivitySignupVo>> search(SportActivitySignupSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportActivitySignupDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
