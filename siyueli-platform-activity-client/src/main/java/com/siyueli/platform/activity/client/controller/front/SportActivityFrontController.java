package com.siyueli.platform.activity.client.controller.front;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivityClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivityGetRequest;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySearchRequest;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "前台_体育活动管理接口")
@RestController
@RequestMapping("/sportActivityFront")
public class SportActivityFrontController extends BaseController {

    @Autowired
    private SportActivityClient sportActivityClient;

    @ApiOperation(nickname = "searchSportActivityFront",value = "搜索体育活动接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportActivityVo>> search(@Valid SportActivitySearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityClient.search(requestParam);
    }

    @ApiOperation(nickname = "getSportActivityFront",value = "得到体育活动接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportActivityVo> get(@Valid SportActivityGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportActivityClient.get(requestParam);
    }


}
