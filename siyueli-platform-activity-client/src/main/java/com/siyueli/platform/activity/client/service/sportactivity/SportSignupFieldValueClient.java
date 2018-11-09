package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportSignupFieldValueFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportSignupFieldValueVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportSignupFieldValueFallBack.class)
public interface SportSignupFieldValueClient {

    @RequestMapping(value = "/sportSignupFieldValue/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportSignupFieldValueAddRequest requestParam);

    @RequestMapping(value = "/sportSignupFieldValue/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportSignupFieldValueUpdateRequest requestParam);

    @RequestMapping(value = "/sportSignupFieldValue/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportSignupFieldValueVo> get(@RequestBody SportSignupFieldValueGetRequest requestParam);

    @RequestMapping(value = "/sportSignupFieldValue/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportSignupFieldValueVo>> search(@RequestBody SportSignupFieldValueSearchRequest requestParam);

    @RequestMapping(value = "/sportSignupFieldValue/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportSignupFieldValueDeleteRequest requestParam);
}
