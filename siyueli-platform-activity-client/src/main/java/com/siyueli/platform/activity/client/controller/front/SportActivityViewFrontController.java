package com.siyueli.platform.activity.client.controller.front;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityViewClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivityViewAddRequest;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivityViewSearchRequest;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "前台_活动浏览管理接口")
@RestController
@RequestMapping("/sportActivityViewFront")
public class SportActivityViewFrontController extends BaseController {

    @Autowired
    private SportActivityViewClient sportActivityViewClient;

    @ApiOperation(nickname = "addSportActivityViewFront",value = "新增活动浏览接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityViewAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityViewClient.add(requestParam);
    }

    @ApiOperation(nickname = "searchSportActivityViewFront",value = "搜索活动浏览接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityViewVo>> search(@Valid SportActivityViewSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityViewClient.search(requestParam);
    }
}
