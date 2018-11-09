package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportInvitedUserViewFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitedUserViewVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportInvitedUserViewFallBack.class)
public interface SportInvitedUserViewClient {

    @RequestMapping(value = "/sportInvitedUserView/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportInvitedUserViewAddRequest requestParam);

    @RequestMapping(value = "/sportInvitedUserView/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportInvitedUserViewUpdateRequest requestParam);

    @RequestMapping(value = "/sportInvitedUserView/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportInvitedUserViewVo> get(@RequestBody SportInvitedUserViewGetRequest requestParam);

    @RequestMapping(value = "/sportInvitedUserView/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportInvitedUserViewVo>> search(@RequestBody SportInvitedUserViewSearchRequest requestParam);

    @RequestMapping(value = "/sportInvitedUserView/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportInvitedUserViewDeleteRequest requestParam);
}
