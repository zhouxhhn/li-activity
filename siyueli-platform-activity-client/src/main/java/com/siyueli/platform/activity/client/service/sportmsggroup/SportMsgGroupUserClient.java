package com.siyueli.platform.activity.client.service.sportmsggroup;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportmsggroup.SportMsgGroupUserFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportmsggroup.*;
import com.siyueli.platform.activity.common.response.sportmsggroup.SportMsgGroupUserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportMsgGroupUserFallBack.class)
public interface SportMsgGroupUserClient {

    @RequestMapping(value = "/sportMsgGroupUser/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportMsgGroupUserAddRequest requestParam);

    @RequestMapping(value = "/sportMsgGroupUser/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportMsgGroupUserUpdateRequest requestParam);

    @RequestMapping(value = "/sportMsgGroupUser/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportMsgGroupUserVo> get(@RequestBody SportMsgGroupUserGetRequest requestParam);

    @RequestMapping(value = "/sportMsgGroupUser/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportMsgGroupUserVo>> search(@RequestBody SportMsgGroupUserSearchRequest requestParam);

    @RequestMapping(value = "/sportMsgGroupUser/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportMsgGroupUserDeleteRequest requestParam);
}
