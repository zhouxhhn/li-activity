package com.siyueli.platform.activity.client.callback.customform;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.customform.CustomFormFieldRelationshipClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldRelationshipVo;
import org.springframework.stereotype.Component;

@Component
public class CustomFormFieldRelationshipFallBack extends BaseServiceFallBack implements CustomFormFieldRelationshipClient {
    @Override
    public ResponseData add(CustomFormFieldRelationshipAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(CustomFormFieldRelationshipUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<CustomFormFieldRelationshipVo> get(CustomFormFieldRelationshipGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<CustomFormFieldRelationshipVo>> search(CustomFormFieldRelationshipSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(CustomFormFieldRelationshipDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
