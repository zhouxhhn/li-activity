package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportSignupFieldValueClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportSignupFieldValueVo;
import org.springframework.stereotype.Component;

@Component
public class SportSignupFieldValueFallBack extends BaseServiceFallBack implements SportSignupFieldValueClient {
    @Override
    public ResponseData add(SportSignupFieldValueAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportSignupFieldValueUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportSignupFieldValueVo> get(SportSignupFieldValueGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportSignupFieldValueVo>> search(SportSignupFieldValueSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportSignupFieldValueDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
