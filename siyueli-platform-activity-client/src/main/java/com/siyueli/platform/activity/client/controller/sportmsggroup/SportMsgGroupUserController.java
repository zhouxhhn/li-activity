package com.siyueli.platform.activity.client.controller.sportmsggroup;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportmsggroup.SportMsgGroupUserClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportmsggroup.*;
import com.siyueli.platform.activity.common.response.sportmsggroup.SportMsgGroupUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "消息用户组的用户管理接口")
@RestController
@RequestMapping("/sportMsgGroupUser")
public class SportMsgGroupUserController extends BaseController {

    @Autowired
    private SportMsgGroupUserClient sportMsgGroupUserClient;

    @ApiOperation(nickname = "addSportMsgGroupUser",value = "新增消息用户组的用户接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportMsgGroupUserAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMsgGroupUserClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportMsgGroupUser",value = "更新消息用户组的用户接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportMsgGroupUserUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportMsgGroupUserUpdateRequest updateRequest = new SportMsgGroupUserUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportMsgGroupUserClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportMsgGroupUser",value = "得到消息用户组的用户接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportMsgGroupUserVo> get(@Valid SportMsgGroupUserGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMsgGroupUserClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportMsgGroupUser",value = "搜索消息用户组的用户接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportMsgGroupUserVo>> search(@Valid SportMsgGroupUserSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMsgGroupUserClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportMsgGroupUser",value = "删除消息用户组的用户接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportMsgGroupUserDeleteRequest requestParam = new SportMsgGroupUserDeleteRequest();
        requestParam.setId(id);
        return sportMsgGroupUserClient.delete(requestParam);
    }

}
