package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivitySponsorClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivitySponsorVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "体育活动_主办方管理接口")
@RestController
@RequestMapping("/sportActivitySponsor")
public class SportActivitySponsorController extends BaseController {

    @Autowired
    private SportActivitySponsorClient sportActivitySponsorClient;

    @ApiOperation(nickname = "addSportActivitySponsor",value = "新增体育活动_主办方接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivitySponsorAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivitySponsorClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivitySponsor",value = "更新体育活动_主办方接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivitySponsorUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivitySponsorUpdateRequest updateRequest = new SportActivitySponsorUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivitySponsorClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivitySponsor",value = "得到体育活动_主办方接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivitySponsorVo> get(@Valid SportActivitySponsorGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivitySponsorClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivitySponsor",value = "搜索体育活动_主办方接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivitySponsorVo>> search(@Valid SportActivitySponsorSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivitySponsorClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivitySponsor",value = "删除体育活动_主办方接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivitySponsorDeleteRequest requestParam = new SportActivitySponsorDeleteRequest();
        requestParam.setId(id);
        return sportActivitySponsorClient.delete(requestParam);
    }

}
