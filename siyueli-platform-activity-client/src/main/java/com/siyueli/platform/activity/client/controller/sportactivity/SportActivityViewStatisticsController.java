package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityViewStatisticsClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityViewStatisticsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "活动浏览统计管理接口")
@RestController
@RequestMapping("/sportActivityViewStatistics")
public class SportActivityViewStatisticsController extends BaseController {

    @Autowired
    private SportActivityViewStatisticsClient sportActivityViewStatisticsClient;

    @ApiOperation(nickname = "addSportActivityViewStatistics",value = "新增活动浏览统计接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityViewStatisticsAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityViewStatisticsClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivityViewStatistics",value = "更新活动浏览统计接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivityViewStatisticsUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityViewStatisticsUpdateRequest updateRequest = new SportActivityViewStatisticsUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivityViewStatisticsClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivityViewStatistics",value = "得到活动浏览统计接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivityViewStatisticsVo> get(@Valid SportActivityViewStatisticsGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityViewStatisticsClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivityViewStatistics",value = "搜索活动浏览统计接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityViewStatisticsVo>> search(@Valid SportActivityViewStatisticsSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityViewStatisticsClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivityViewStatistics",value = "删除活动浏览统计接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivityViewStatisticsDeleteRequest requestParam = new SportActivityViewStatisticsDeleteRequest();
        requestParam.setId(id);
        return sportActivityViewStatisticsClient.delete(requestParam);
    }

}
