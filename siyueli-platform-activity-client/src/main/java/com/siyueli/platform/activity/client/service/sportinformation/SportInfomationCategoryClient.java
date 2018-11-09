package com.siyueli.platform.activity.client.service.sportinformation;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportinformation.SportInfomationCategoryFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportinfomation.*;
import com.siyueli.platform.activity.common.response.sportinfomation.SportInfomationCategoryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportInfomationCategoryFallBack.class)
public interface SportInfomationCategoryClient {

    @RequestMapping(value = "/sportInfomationCategory/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportInfomationCategoryAddRequest requestParam);

    @RequestMapping(value = "/sportInfomationCategory/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportInfomationCategoryUpdateRequest requestParam);

    @RequestMapping(value = "/sportInfomationCategory/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportInfomationCategoryVo> get(@RequestBody SportInfomationCategoryGetRequest requestParam);

    @RequestMapping(value = "/sportInfomationCategory/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportInfomationCategoryVo>> search(@RequestBody SportInfomationCategorySearchRequest requestParam);

    @RequestMapping(value = "/sportInfomationCategory/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportInfomationCategoryDeleteRequest requestParam);
}
