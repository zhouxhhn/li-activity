package com.siyueli.platform.activity.client.service.customform;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.customform.CustomFormFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = CustomFormFallBack.class)
public interface CustomFormClient {

    @RequestMapping(value = "/customForm/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody CustomFormAddRequest requestParam);

    @RequestMapping(value = "/customForm/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody CustomFormUpdateRequest requestParam);

    @RequestMapping(value = "/customForm/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<CustomFormVo> get(@RequestBody CustomFormGetRequest requestParam);

    @RequestMapping(value = "/customForm/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<CustomFormVo>> search(@RequestBody CustomFormSearchRequest requestParam);

    @RequestMapping(value = "/customForm/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody CustomFormDeleteRequest requestParam);
}
