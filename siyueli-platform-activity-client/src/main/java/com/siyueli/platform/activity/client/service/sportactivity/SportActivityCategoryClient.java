package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportActivityCategoryFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityCategoryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportActivityCategoryFallBack.class)
public interface SportActivityCategoryClient {

    @RequestMapping(value = "/sportActivityCategory/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportActivityCategoryAddRequest requestParam);

    @RequestMapping(value = "/sportActivityCategory/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportActivityCategoryUpdateRequest requestParam);

    @RequestMapping(value = "/sportActivityCategory/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportActivityCategoryVo> get(@RequestBody SportActivityCategoryGetRequest requestParam);

    @RequestMapping(value = "/sportActivityCategory/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportActivityCategoryVo>> search(@RequestBody SportActivityCategorySearchRequest requestParam);

    @RequestMapping(value = "/sportActivityCategory/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportActivityCategoryDeleteRequest requestParam);
}
