package com.siyueli.platform.activity.client.callback.customform;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.customform.CustomFormClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormVo;
import org.springframework.stereotype.Component;

@Component
public class CustomFormFallBack extends BaseServiceFallBack implements CustomFormClient {
    @Override
    public ResponseData add(CustomFormAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(CustomFormUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<CustomFormVo> get(CustomFormGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<CustomFormVo>> search(CustomFormSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(CustomFormDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
