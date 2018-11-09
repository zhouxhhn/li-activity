package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportActivityRefundOrderFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityRefundOrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportActivityRefundOrderFallBack.class)
public interface SportActivityRefundOrderClient {

    @RequestMapping(value = "/sportActivityRefundOrder/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportActivityRefundOrderAddRequest requestParam);

    @RequestMapping(value = "/sportActivityRefundOrder/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportActivityRefundOrderUpdateRequest requestParam);

    @RequestMapping(value = "/sportActivityRefundOrder/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportActivityRefundOrderVo> get(@RequestBody SportActivityRefundOrderGetRequest requestParam);

    @RequestMapping(value = "/sportActivityRefundOrder/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportActivityRefundOrderVo>> search(@RequestBody SportActivityRefundOrderSearchRequest requestParam);

    @RequestMapping(value = "/sportActivityRefundOrder/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportActivityRefundOrderDeleteRequest requestParam);
}
