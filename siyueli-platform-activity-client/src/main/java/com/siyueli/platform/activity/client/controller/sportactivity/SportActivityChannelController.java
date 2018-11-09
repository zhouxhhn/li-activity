package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityChannelClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityChannelVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "活动渠道管理接口")
@RestController
@RequestMapping("/sportActivityChannel")
public class SportActivityChannelController extends BaseController {

    @Autowired
    private SportActivityChannelClient sportActivityChannelClient;

    @ApiOperation(nickname = "addSportActivityChannel",value = "新增活动渠道接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityChannelAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityChannelClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivityChannel",value = "更新活动渠道接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivityChannelUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityChannelUpdateRequest updateRequest = new SportActivityChannelUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivityChannelClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivityChannel",value = "得到活动渠道接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivityChannelVo> get(@Valid SportActivityChannelGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityChannelClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivityChannel",value = "搜索活动渠道接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityChannelVo>> search(@Valid SportActivityChannelSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityChannelClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivityChannel",value = "删除活动渠道接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivityChannelDeleteRequest requestParam = new SportActivityChannelDeleteRequest();
        requestParam.setId(id);
        return sportActivityChannelClient.delete(requestParam);
    }

    @ApiOperation(nickname = "updateStatus",value = "更新活动渠道状态接口")
    @LogAnnotation
    @PostMapping("/updateStatus")
    public ResponseData updateStatus(@Valid @RequestBody SportActivityChannelUpdateStatusRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportActivityChannelClient.updateStatus(requestParam);
        return ResponseUtil.success();
    }

}
