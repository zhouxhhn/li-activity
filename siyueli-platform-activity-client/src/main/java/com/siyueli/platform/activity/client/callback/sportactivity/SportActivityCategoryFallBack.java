package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityCategoryClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityCategoryVo;
import org.springframework.stereotype.Component;

@Component
public class SportActivityCategoryFallBack extends BaseServiceFallBack implements SportActivityCategoryClient {
    @Override
    public ResponseData add(SportActivityCategoryAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportActivityCategoryUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportActivityCategoryVo> get(SportActivityCategoryGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportActivityCategoryVo>> search(SportActivityCategorySearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportActivityCategoryDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
