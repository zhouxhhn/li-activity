package com.siyueli.platform.activity.client.callback.customform;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.customform.CustomFormFieldClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.customformfield.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldVo;
import org.springframework.stereotype.Component;

@Component
public class CustomFormFieldFallBack extends BaseServiceFallBack implements CustomFormFieldClient {
    @Override
    public ResponseData add(AddCustomFormFieldRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(UpdateCustomFormFieldRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<CustomFormFieldVo> get(GetCustomFormFieldRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<CustomFormFieldVo>> search(SearchCustomFormFieldRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(DeleteCustomFormFieldRequest requestParam) {
        return getDownGradeResponse();
    }
}
