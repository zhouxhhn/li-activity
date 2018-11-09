package com.siyueli.platform.activity.service.controller.sportactivity;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportactivity.SportInvitationLetter;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitationLetterVo;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.sportactivity.SportInvitationLetterServiceContract;
import com.siyueli.platform.activity.service.service.user.UserService;
import com.siyueli.platform.activity.service.util.ConvertUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Api(tags = "邀请函管理接口")
@RestController
@RequestMapping("/sportInvitationLetter")
public class SportInvitationLetterController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportInvitationLetterController.class);

    @Autowired
    private SportInvitationLetterServiceContract sportInvitationLetterService;

    @Autowired
    private UserService userService;

    @ApiOperation(nickname = "add",value = "新增邀请函接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportInvitationLetterAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInvitationLetter entity = new SportInvitationLetter();
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportInvitationLetterService.insertAllColumn(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "update",value = "更新邀请函接口")
    @LogAnnotation
    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody SportInvitationLetterUpdateRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInvitationLetter entity = sportInvitationLetterService.selectById(requestParam.getId());
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setUpdateAt(now);

        sportInvitationLetterService.updateAllColumnById(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "search",value = "搜索邀请函接口")
    @LogAnnotation
    @PostMapping("/search")
    public ResponseData search(@Valid @RequestBody SportInvitationLetterSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        EntityWrapper<SportInvitationLetter> entityWrapper = new EntityWrapper<SportInvitationLetter>();
        Page<SportInvitationLetter> page = new Page<SportInvitationLetter>(requestParam.getPage(), requestParam.getSize());
        Page<SportInvitationLetter> resultPage = sportInvitationLetterService.selectPage(page, entityWrapper);
        try {
            PageResponse<SportInvitationLetterVo> pageResponse = ConvertUtil.getPageResponse(resultPage, SportInvitationLetterVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }

    @ApiOperation(nickname = "get",value = "得到邀请函接口")
    @LogAnnotation
    @PostMapping("/get")
    public ResponseData get(@Valid @RequestBody SportInvitationLetterGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInvitationLetter entity = sportInvitationLetterService.selectById(requestParam.getId());
        SportInvitationLetterVo cffVo = null;
        if (entity != null) {
            cffVo = new SportInvitationLetterVo();
            BeanUtils.copyProperties(entity, cffVo);
        }
        return ResponseUtil.success(cffVo);
    }

    @ApiOperation(nickname = "delete",value = "删除邀请函接口")
    @LogAnnotation
    @PostMapping("/delete")
    public ResponseData delete(@Valid @RequestBody SportInvitationLetterDeleteRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportInvitationLetterService.deleteById(requestParam.getId());
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "inviteTeamMember",value = "邀请队友接口")
    @LogAnnotation
    @PostMapping("/inviteTeamMember")
    public ResponseData inviteTeamMember(@Valid @RequestBody SportInvitationLetterInviteTeamMemberRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        String userId = userService.getUserIdByFrontToken(token);

        sportInvitationLetterService.inviteTeamMember(new Long(userId), requestParam.getActivityId());
        return ResponseUtil.success();
    }

}
