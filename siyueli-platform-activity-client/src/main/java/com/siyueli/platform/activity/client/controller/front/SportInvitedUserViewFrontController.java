package com.siyueli.platform.activity.client.controller.front;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportInvitedUserViewClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.SportInvitedUserViewAddRequest;
import com.siyueli.platform.activity.common.request.sportactivity.SportInvitedUserViewSearchRequest;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitedUserViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api(tags = "前台_邀请函浏览信息管理接口")
@RestController
@RequestMapping("/sportInvitedUserViewFront")
public class SportInvitedUserViewFrontController extends BaseController {

    @Autowired
    private SportInvitedUserViewClient sportInvitedUserViewClient;

    @ApiOperation(nickname = "addSportInvitedUserViewFront",value = "新增邀请函浏览信息接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportInvitedUserViewAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitedUserViewClient.add(requestParam);
    }

    @ApiOperation(nickname = "searchSportInvitedUserViewFront",value = "搜索邀请函浏览信息接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportInvitedUserViewVo>> search(@Valid SportInvitedUserViewSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitedUserViewClient.search(requestParam);
    }
}
