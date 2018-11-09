package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportChannelFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportChannelVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportChannelFallBack.class)
public interface SportChannelClient {

    @RequestMapping(value = "/sportChannel/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportChannelAddRequest requestParam);

    @RequestMapping(value = "/sportChannel/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportChannelUpdateRequest requestParam);

    @RequestMapping(value = "/sportChannel/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportChannelVo> get(@RequestBody SportChannelGetRequest requestParam);

    @RequestMapping(value = "/sportChannel/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportChannelVo>> search(@RequestBody SportChannelSearchRequest requestParam);

    @RequestMapping(value = "/sportChannel/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportChannelDeleteRequest requestParam);
}
