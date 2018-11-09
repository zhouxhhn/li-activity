package com.siyueli.platform.activity.client.service.sportinformation;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportinformation.SportInformationFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportinfomation.*;
import com.siyueli.platform.activity.common.response.sportinfomation.SportInformationVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportInformationFallBack.class)
public interface SportInformationClient {

    @RequestMapping(value = "/sportInformation/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportInformationAddRequest requestParam);

    @RequestMapping(value = "/sportInformation/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportInformationUpdateRequest requestParam);

    @RequestMapping(value = "/sportInformation/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportInformationVo> get(@RequestBody SportInformationGetRequest requestParam);

    @RequestMapping(value = "/sportInformation/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportInformationVo>> search(@RequestBody SportInformationSearchRequest requestParam);

    @RequestMapping(value = "/sportInformation/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportInformationDeleteRequest requestParam);
}
