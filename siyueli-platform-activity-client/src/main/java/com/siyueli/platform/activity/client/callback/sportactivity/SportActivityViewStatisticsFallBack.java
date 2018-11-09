package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityViewStatisticsClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityViewStatisticsVo;
import org.springframework.stereotype.Component;

@Component
public class SportActivityViewStatisticsFallBack extends BaseServiceFallBack implements SportActivityViewStatisticsClient {
    @Override
    public ResponseData add(SportActivityViewStatisticsAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportActivityViewStatisticsUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportActivityViewStatisticsVo> get(SportActivityViewStatisticsGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportActivityViewStatisticsVo>> search(SportActivityViewStatisticsSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportActivityViewStatisticsDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
