package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportActivitySignupFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivitySignupVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportActivitySignupFallBack.class)
public interface SportActivitySignupClient {

    @RequestMapping(value = "/sportActivitySignup/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportActivitySignupAddRequest requestParam);

    @RequestMapping(value = "/sportActivitySignup/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportActivitySignupUpdateRequest requestParam);

    @RequestMapping(value = "/sportActivitySignup/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportActivitySignupVo> get(@RequestBody SportActivitySignupGetRequest requestParam);

    @RequestMapping(value = "/sportActivitySignup/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportActivitySignupVo>> search(@RequestBody SportActivitySignupSearchRequest requestParam);

    @RequestMapping(value = "/sportActivitySignup/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportActivitySignupDeleteRequest requestParam);
}
