package com.siyueli.platform.activity.client.callback.sportinformation;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportinformation.SportInfomationCategoryClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportinfomation.*;
import com.siyueli.platform.activity.common.response.sportinfomation.SportInfomationCategoryVo;
import org.springframework.stereotype.Component;

@Component
public class SportInfomationCategoryFallBack extends BaseServiceFallBack implements SportInfomationCategoryClient {
    @Override
    public ResponseData add(SportInfomationCategoryAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportInfomationCategoryUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportInfomationCategoryVo> get(SportInfomationCategoryGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportInfomationCategoryVo>> search(SportInfomationCategorySearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportInfomationCategoryDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
