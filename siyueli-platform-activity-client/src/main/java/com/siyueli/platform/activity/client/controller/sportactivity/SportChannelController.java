package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportChannelClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportChannelVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "渠道管理接口")
@RestController
@RequestMapping("/sportChannel")
public class SportChannelController extends BaseController {

    @Autowired
    private SportChannelClient sportChannelClient;

    @ApiOperation(nickname = "addSportChannel",value = "新增渠道接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportChannelAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportChannelClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportChannel",value = "更新渠道接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportChannelUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportChannelUpdateRequest updateRequest = new SportChannelUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportChannelClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportChannel",value = "得到渠道接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportChannelVo> get(@Valid SportChannelGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportChannelClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportChannel",value = "搜索渠道接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportChannelVo>> search(@Valid SportChannelSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportChannelClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportChannel",value = "删除渠道接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportChannelDeleteRequest requestParam = new SportChannelDeleteRequest();
        requestParam.setId(id);
        return sportChannelClient.delete(requestParam);
    }

}
