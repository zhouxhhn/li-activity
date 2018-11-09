package com.siyueli.platform.activity.client.callback.customform;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.customform.CustomFieldOptionClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.customfieldoption.*;
import com.siyueli.platform.activity.common.response.customform.CustomFieldOptionVo;
import org.springframework.stereotype.Component;

@Component
public class CustomFieldOptionFallBack extends BaseServiceFallBack implements CustomFieldOptionClient {
    @Override
    public ResponseData add(AddCustomFieldOptionRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(UpdateCustomFieldOptionRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<CustomFieldOptionVo> get(GetCustomFieldOptionRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<CustomFieldOptionVo>> search(SearchCustomFieldOptionRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(DeleteCustomFieldOptionRequest requestParam) {
        return getDownGradeResponse();
    }
}
