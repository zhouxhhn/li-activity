package com.siyueli.platform.activity.client.controller.front;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivitySignupClient;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySignupAddRequest;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySignupGetRequest;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivitySignupVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "前台_活动报名管理接口")
@RestController
@RequestMapping("/sportActivitySignupFront")
public class SportActivitySignupFrontController extends BaseController {

    @Autowired
    private SportActivitySignupClient sportActivitySignupClient;

    @ApiOperation(nickname = "addSportActivitySignupFront",value = "新增活动报名接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivitySignupAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivitySignupClient.add(requestParam);
    }

    @ApiOperation(nickname = "getSportActivitySignupFront",value = "得到活动报名接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivitySignupVo> get(@Valid SportActivitySignupGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivitySignupClient.get(requestParam);
    }
}
