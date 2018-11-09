package com.siyueli.platform.activity.client.controller.sportactivity;


import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportInvitationLetterClient;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitationLetterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "邀请函管理接口")
@RestController
@RequestMapping("/sportInvitationLetter")
public class SportInvitationLetterController extends BaseController {

    @Autowired
    private SportInvitationLetterClient sportInvitationLetterClient;



    @ApiOperation(nickname = "addSportInvitationLetter",value = "新增邀请函接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportInvitationLetterAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitationLetterClient.add(requestParam);
    }

    @ApiOperation(nickname = "updateSportInvitationLetter",value = "更新邀请函接口")
    @LogAnnotation
    @PostMapping("/update/{id}")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody SportInvitationLetterUpdateFrontRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInvitationLetterUpdateRequest updateRequest = new SportInvitationLetterUpdateRequest();
        BeanUtils.copyProperties(requestParam, updateRequest);
        updateRequest.setId(id);
        return sportInvitationLetterClient.update(updateRequest);
    }

    @ApiOperation(nickname = "getSportInvitationLetter",value = "得到邀请函接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData<SportInvitationLetterVo> get(@Valid SportInvitationLetterGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitationLetterClient.get(requestParam);
    }

    @ApiOperation(nickname = "searchSportInvitationLetter",value = "搜索邀请函接口")
    @LogAnnotation
    @GetMapping("/search")
    public ResponseData<PageResponse<SportInvitationLetterVo>> search(@Valid SportInvitationLetterSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportInvitationLetterClient.search(requestParam);
    }

    @ApiOperation(nickname = "deleteSportInvitationLetter",value = "删除邀请函接口")
    @LogAnnotation
    @PostMapping("/delete/{id}")
    public ResponseData delete(@PathVariable(value = "id") Long id) {
        SportInvitationLetterDeleteRequest requestParam = new SportInvitationLetterDeleteRequest();
        requestParam.setId(id);
        return sportInvitationLetterClient.delete(requestParam);
    }

    @ApiOperation(nickname = "inviteTeamMember",value = "邀请队友接口")
    @LogAnnotation
    @PostMapping("/inviteTeamMember")
    public ResponseData inviteTeamMember(@Valid @RequestBody SportInvitationLetterInviteTeamMemberRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        return sportInvitationLetterClient.inviteTeamMember(requestParam);
    }

}
