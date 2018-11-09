package com.siyueli.platform.activity.client.service.customform;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.customform.CustomFormCategoryFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.customformcategory.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormCategoryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = CustomFormCategoryFallBack.class)
public interface CustomFormCategoryClient {

    @RequestMapping(value = "/customFormCategory/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody AddCustomFormCategoryRequest requestParam);

    @RequestMapping(value = "/customFormCategory/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody UpdateCustomFormCategoryRequest requestParam);

    @RequestMapping(value = "/customFormCategory/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<CustomFormCategoryVo> get(@RequestBody GetCustomFormCategoryRequest requestParam);

    @RequestMapping(value = "/customFormCategory/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<CustomFormCategoryVo>> search(@RequestBody SearchCustomFormCategoryRequest requestParam);

    @RequestMapping(value = "/customFormCategory/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody DeleteCustomFormCategoryRequest requestParam);
}
