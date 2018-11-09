package com.siyueli.platform.activity.client.controller.front;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportInvitationLetterClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.SportInvitationLetterAddRequest;
import com.siyueli.platform.activity.common.request.sportactivity.SportInvitationLetterSearchRequest;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitationLetterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "前台_邀请函管理接口")
@RestController
@RequestMapping("/sportInvitationLetterFront")
public class SportInvitationLetterFrontController extends BaseController {

    @Autowired
    private SportInvitationLetterClient sportInvitationLetterClient;

    @ApiOperation(nickname = "addSportInvitationLetterFront",value = "新增邀请函接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportInvitationLetterAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitationLetterClient.add(requestParam);
    }

    @ApiOperation(nickname = "searchSportInvitationLetterFront",value = "搜索邀请函接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportInvitationLetterVo>> search(@Valid SportInvitationLetterSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitationLetterClient.search(requestParam);
    }
}
