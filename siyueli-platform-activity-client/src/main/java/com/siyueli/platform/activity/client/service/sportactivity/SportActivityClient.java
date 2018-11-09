package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportActivityFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportActivityFallBack.class)
public interface SportActivityClient {

    @RequestMapping(value = "/sportActivity/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportActivityAddRequest requestParam);

    @RequestMapping(value = "/sportActivity/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportActivityUpdateRequest requestParam);

    @RequestMapping(value = "/sportActivity/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportActivityVo> get(@RequestBody SportActivityGetRequest requestParam);

    @RequestMapping(value = "/sportActivity/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportActivityVo>> search(@RequestBody SportActivitySearchRequest requestParam);

    @RequestMapping(value = "/sportActivity/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportActivityDeleteRequest requestParam);
}
