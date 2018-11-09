package com.siyueli.platform.activity.client.callback.sportinformation;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportinformation.SportInformationClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportinfomation.*;
import com.siyueli.platform.activity.common.response.sportinfomation.SportInformationVo;
import org.springframework.stereotype.Component;

@Component
public class SportInformationFallBack extends BaseServiceFallBack implements SportInformationClient {
    @Override
    public ResponseData add(SportInformationAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportInformationUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportInformationVo> get(SportInformationGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportInformationVo>> search(SportInformationSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportInformationDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
