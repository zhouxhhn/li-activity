package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportActivityOrderFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityOrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportActivityOrderFallBack.class)
public interface SportActivityOrderClient {

    @RequestMapping(value = "/sportActivityOrder/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportActivityOrderAddRequest requestParam);

    @RequestMapping(value = "/sportActivityOrder/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportActivityOrderUpdateRequest requestParam);

    @RequestMapping(value = "/sportActivityOrder/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportActivityOrderVo> get(@RequestBody SportActivityOrderGetRequest requestParam);

    @RequestMapping(value = "/sportActivityOrder/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportActivityOrderVo>> search(@RequestBody SportActivityOrderSearchRequest requestParam);

    @RequestMapping(value = "/sportActivityOrder/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportActivityOrderDeleteRequest requestParam);
}
