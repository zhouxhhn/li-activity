package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportInvitationLetterFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitationLetterVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportInvitationLetterFallBack.class)
public interface SportInvitationLetterClient {

    @RequestMapping(value = "/sportInvitationLetter/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportInvitationLetterAddRequest requestParam);

    @RequestMapping(value = "/sportInvitationLetter/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportInvitationLetterUpdateRequest requestParam);

    @RequestMapping(value = "/sportInvitationLetter/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportInvitationLetterVo> get(@RequestBody SportInvitationLetterGetRequest requestParam);

    @RequestMapping(value = "/sportInvitationLetter/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportInvitationLetterVo>> search(@RequestBody SportInvitationLetterSearchRequest requestParam);

    @RequestMapping(value = "/sportInvitationLetter/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportInvitationLetterDeleteRequest requestParam);

    @RequestMapping(value = "/sportInvitationLetter/inviteTeamMember", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData inviteTeamMember(@RequestBody SportInvitationLetterInviteTeamMemberRequest requestParam);
}
