package com.siyueli.platform.activity.client.service.customform;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.customform.CustomFormFieldRelationshipFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.customform.*;
import com.siyueli.platform.activity.common.response.customform.CustomFormFieldRelationshipVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = CustomFormFieldRelationshipFallBack.class)
public interface CustomFormFieldRelationshipClient {

    @RequestMapping(value = "/customFormFieldRelationship/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody CustomFormFieldRelationshipAddRequest requestParam);

    @RequestMapping(value = "/customFormFieldRelationship/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody CustomFormFieldRelationshipUpdateRequest requestParam);

    @RequestMapping(value = "/customFormFieldRelationship/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<CustomFormFieldRelationshipVo> get(@RequestBody CustomFormFieldRelationshipGetRequest requestParam);

    @RequestMapping(value = "/customFormFieldRelationship/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<CustomFormFieldRelationshipVo>> search(@RequestBody CustomFormFieldRelationshipSearchRequest requestParam);

    @RequestMapping(value = "/customFormFieldRelationship/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody CustomFormFieldRelationshipDeleteRequest requestParam);
}
