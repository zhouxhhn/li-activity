package com.siyueli.platform.activity.client.service.sportmsggroup;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportmsggroup.SportMsgGroupFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportmsggroup.*;
import com.siyueli.platform.activity.common.response.sportmsggroup.SportMsgGroupVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportMsgGroupFallBack.class)
public interface SportMsgGroupClient {

    @RequestMapping(value = "/sportMsgGroup/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportMsgGroupAddRequest requestParam);

    @RequestMapping(value = "/sportMsgGroup/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportMsgGroupUpdateRequest requestParam);

    @RequestMapping(value = "/sportMsgGroup/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportMsgGroupVo> get(@RequestBody SportMsgGroupGetRequest requestParam);

    @RequestMapping(value = "/sportMsgGroup/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportMsgGroupVo>> search(@RequestBody SportMsgGroupSearchRequest requestParam);

    @RequestMapping(value = "/sportMsgGroup/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportMsgGroupDeleteRequest requestParam);
}
