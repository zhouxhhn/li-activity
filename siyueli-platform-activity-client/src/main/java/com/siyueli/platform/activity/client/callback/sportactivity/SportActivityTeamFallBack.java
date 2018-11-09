package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityTeamClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityTeamVo;
import org.springframework.stereotype.Component;

@Component
public class SportActivityTeamFallBack extends BaseServiceFallBack implements SportActivityTeamClient {
    @Override
    public ResponseData add(SportActivityTeamAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportActivityTeamUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportActivityTeamVo> get(SportActivityTeamGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportActivityTeamVo>> search(SportActivityTeamSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportActivityTeamDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
