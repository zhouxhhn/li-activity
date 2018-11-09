package com.siyueli.platform.activity.client.service.sportactivity;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.sportactivity.SportActivityViewStatisticsFallBack;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityViewStatisticsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = SportActivityViewStatisticsFallBack.class)
public interface SportActivityViewStatisticsClient {

    @RequestMapping(value = "/sportActivityViewStatistics/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData add(@RequestBody SportActivityViewStatisticsAddRequest requestParam);

    @RequestMapping(value = "/sportActivityViewStatistics/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData update(@RequestBody SportActivityViewStatisticsUpdateRequest requestParam);

    @RequestMapping(value = "/sportActivityViewStatistics/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<SportActivityViewStatisticsVo> get(@RequestBody SportActivityViewStatisticsGetRequest requestParam);

    @RequestMapping(value = "/sportActivityViewStatistics/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<PageResponse<SportActivityViewStatisticsVo>> search(@RequestBody SportActivityViewStatisticsSearchRequest requestParam);

    @RequestMapping(value = "/sportActivityViewStatistics/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData delete(@RequestBody SportActivityViewStatisticsDeleteRequest requestParam);
}
