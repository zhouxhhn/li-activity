package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportActivityChannelFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityChannelVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportActivityChannelFallBack.class)
public interface SportActivityChannelClient {

    @RequestMapping(value = "/sportActivityChannel/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportActivityChannelAddRequest requestParam);

    @RequestMapping(value = "/sportActivityChannel/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportActivityChannelUpdateRequest requestParam);

    @RequestMapping(value = "/sportActivityChannel/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportActivityChannelVo> get(@RequestBody SportActivityChannelGetRequest requestParam);

    @RequestMapping(value = "/sportActivityChannel/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportActivityChannelVo>> search(@RequestBody SportActivityChannelSearchRequest requestParam);

    @RequestMapping(value = "/sportActivityChannel/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportActivityChannelDeleteRequest requestParam);

    @RequestMapping(value = "/sportActivityChannel/updateStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData updateStatus(@RequestBody SportActivityChannelUpdateStatusRequest requestParam);
}
