package com.siyueli.platform.activity.client.service.customform;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.customform.CustomFormFieldFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.customformfield.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = CustomFormFieldFallBack.class)
public interface CustomFormFieldClient {

    @RequestMapping(value = "/customFormField/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody AddCustomFormFieldRequest requestParam);

    @RequestMapping(value = "/customFormField/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody UpdateCustomFormFieldRequest requestParam);

    @RequestMapping(value = "/customFormField/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<CustomFormFieldVo> get(@RequestBody GetCustomFormFieldRequest requestParam);

    @RequestMapping(value = "/customFormField/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<CustomFormFieldVo>> search(@RequestBody SearchCustomFormFieldRequest requestParam);

    @RequestMapping(value = "/customFormField/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody DeleteCustomFormFieldRequest requestParam);
}
