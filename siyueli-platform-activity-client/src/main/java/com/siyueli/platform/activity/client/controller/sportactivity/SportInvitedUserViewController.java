package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportInvitedUserViewClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitedUserViewVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "邀请函浏览信息管理接口")
@RestController
@RequestMapping("/sportInvitedUserView")
public class SportInvitedUserViewController extends BaseController {

    @Autowired
    private SportInvitedUserViewClient sportInvitedUserViewClient;

    @ApiOperation(nickname = "addSportInvitedUserView",value = "新增邀请函浏览信息接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportInvitedUserViewAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitedUserViewClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportInvitedUserView",value = "更新邀请函浏览信息接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportInvitedUserViewUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInvitedUserViewUpdateRequest updateRequest = new SportInvitedUserViewUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportInvitedUserViewClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportInvitedUserView",value = "得到邀请函浏览信息接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportInvitedUserViewVo> get(@Valid SportInvitedUserViewGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitedUserViewClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportInvitedUserView",value = "搜索邀请函浏览信息接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportInvitedUserViewVo>> search(@Valid SportInvitedUserViewSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitedUserViewClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportInvitedUserView",value = "删除邀请函浏览信息接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportInvitedUserViewDeleteRequest requestParam = new SportInvitedUserViewDeleteRequest();
        requestParam.setId(id);
        return sportInvitedUserViewClient.delete(requestParam);
    }

}
