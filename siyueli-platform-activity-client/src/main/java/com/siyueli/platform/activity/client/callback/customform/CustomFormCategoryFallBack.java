package com.siyueli.platform.activity.client.callback.customform;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.customform.CustomFormCategoryClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.customformcategory.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormCategoryVo;
import org.springframework.stereotype.Component;

@Component
public class CustomFormCategoryFallBack extends BaseServiceFallBack implements CustomFormCategoryClient {
    @Override
    public ResponseData add(AddCustomFormCategoryRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(UpdateCustomFormCategoryRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<CustomFormCategoryVo> get(GetCustomFormCategoryRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<CustomFormCategoryVo>> search(SearchCustomFormCategoryRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(DeleteCustomFormCategoryRequest requestParam) {
        return getDownGradeResponse();
    }
}
