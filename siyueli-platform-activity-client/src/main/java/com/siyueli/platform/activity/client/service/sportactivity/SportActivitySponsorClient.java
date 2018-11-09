package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportActivitySponsorFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivitySponsorVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportActivitySponsorFallBack.class)
public interface SportActivitySponsorClient {

    @RequestMapping(value = "/sportActivitySponsor/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportActivitySponsorAddRequest requestParam);

    @RequestMapping(value = "/sportActivitySponsor/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportActivitySponsorUpdateRequest requestParam);

    @RequestMapping(value = "/sportActivitySponsor/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportActivitySponsorVo> get(@RequestBody SportActivitySponsorGetRequest requestParam);

    @RequestMapping(value = "/sportActivitySponsor/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportActivitySponsorVo>> search(@RequestBody SportActivitySponsorSearchRequest requestParam);

    @RequestMapping(value = "/sportActivitySponsor/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportActivitySponsorDeleteRequest requestParam);
}
