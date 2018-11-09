package com.siyueli.platform.activity.client.callback.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityRefundOrderClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityRefundOrderVo;
import org.springframework.stereotype.Component;

@Component
public class SportActivityRefundOrderFallBack extends BaseServiceFallBack implements SportActivityRefundOrderClient {
    @Override
    public ResponseData add(SportActivityRefundOrderAddRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData update(SportActivityRefundOrderUpdateRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<SportActivityRefundOrderVo> get(SportActivityRefundOrderGetRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData<PageResponse<SportActivityRefundOrderVo>> search(SportActivityRefundOrderSearchRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData delete(SportActivityRefundOrderDeleteRequest requestParam) {
        return getDownGradeResponse();
    }
}
