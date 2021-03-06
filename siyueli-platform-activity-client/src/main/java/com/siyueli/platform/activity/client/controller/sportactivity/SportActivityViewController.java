package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityViewClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "活动浏览管理接口")
@RestController
@RequestMapping("/sportActivityView")
public class SportActivityViewController extends BaseController {

    @Autowired
    private SportActivityViewClient sportActivityViewClient;

    @ApiOperation(nickname = "addSportActivityView",value = "新增活动浏览接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityViewAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityViewClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivityView",value = "更新活动浏览接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivityViewUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityViewUpdateRequest updateRequest = new SportActivityViewUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivityViewClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivityView",value = "得到活动浏览接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivityViewVo> get(@Valid SportActivityViewGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityViewClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivityView",value = "搜索活动浏览接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityViewVo>> search(@Valid SportActivityViewSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityViewClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivityView",value = "删除活动浏览接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivityViewDeleteRequest requestParam = new SportActivityViewDeleteRequest();
        requestParam.setId(id);
        return sportActivityViewClient.delete(requestParam);
    }

}
