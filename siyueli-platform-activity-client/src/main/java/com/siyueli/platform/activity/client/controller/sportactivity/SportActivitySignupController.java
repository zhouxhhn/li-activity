package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivitySignupClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivitySignupVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "活动报名管理接口")
@RestController
@RequestMapping("/sportActivitySignup")
public class SportActivitySignupController extends BaseController {

    @Autowired
    private SportActivitySignupClient sportActivitySignupClient;

    @ApiOperation(nickname = "addSportActivitySignup",value = "新增活动报名接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivitySignupAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivitySignupClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportActivitySignup",value = "更新活动报名接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportActivitySignupUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivitySignupUpdateRequest updateRequest = new SportActivitySignupUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportActivitySignupClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportActivitySignup",value = "得到活动报名接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivitySignupVo> get(@Valid SportActivitySignupGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivitySignupClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivitySignup",value = "搜索活动报名接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivitySignupVo>> search(@Valid SportActivitySignupSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivitySignupClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportActivitySignup",value = "删除活动报名接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportActivitySignupDeleteRequest requestParam = new SportActivitySignupDeleteRequest();
        requestParam.setId(id);
        return sportActivitySignupClient.delete(requestParam);
    }

    @ApiOperation(nickname = "updateStatus",value = "更新活动状态接口")
    @LogAnnotation
    @PostMapping("/updateStatus")
    public ResponseData updateStatus(@Valid @RequestBody SportActivitySignupUpdateStatusRequest requestParam, BindingResult result) {
        //return sportActivitySignupClient.updateStatus(requestParam);
        return null;
    }

}
