package com.siyueli.platform.activity.service.controller.sportactivity;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportactivity.SportInvitedUserView;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportInvitedUserViewVo;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.sportactivity.SportInvitedUserViewServiceContract;
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

@Api(tags = "邀请函浏览信息管理接口")
@RestController
@RequestMapping("/sportInvitedUserView")
public class SportInvitedUserViewController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportInvitedUserViewController.class);

    @Autowired
    private SportInvitedUserViewServiceContract sportInvitedUserViewService;

    @Autowired
    private UserService userService;

    @ApiOperation(nickname = "add",value = "新增邀请函浏览信息接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportInvitedUserViewAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInvitedUserView entity = new SportInvitedUserView();
        BeanUtils.copyProperties(requestParam, entity);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        String userId = userService.getUserIdByFrontToken(token);

        entity.setUserId(new Long(userId));
        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportInvitedUserViewService.insertAllColumn(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "update",value = "更新邀请函浏览信息接口")
    @LogAnnotation
    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody SportInvitedUserViewUpdateRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInvitedUserView entity = sportInvitedUserViewService.selectById(requestParam.getId());
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setUpdateAt(now);

        sportInvitedUserViewService.updateAllColumnById(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "search",value = "搜索邀请函浏览信息接口")
    @LogAnnotation
    @PostMapping("/search")
    public ResponseData search(@Valid @RequestBody SportInvitedUserViewSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        EntityWrapper<SportInvitedUserView> entityWrapper = new EntityWrapper<SportInvitedUserView>();
        Page<SportInvitedUserView> page = new Page<SportInvitedUserView>(requestParam.getPage(), requestParam.getSize());
        Page<SportInvitedUserView> resultPage = sportInvitedUserViewService.selectPage(page, entityWrapper);
        try {
            PageResponse<SportInvitedUserViewVo> pageResponse = ConvertUtil.getPageResponse(resultPage, SportInvitedUserViewVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }

    @ApiOperation(nickname = "get",value = "得到邀请函浏览信息接口")
    @LogAnnotation
    @PostMapping("/get")
    public ResponseData get(@Valid @RequestBody SportInvitedUserViewGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportInvitedUserView entity = sportInvitedUserViewService.selectById(requestParam.getId());
        SportInvitedUserViewVo cffVo = null;
        if (entity != null) {
            cffVo = new SportInvitedUserViewVo();
            BeanUtils.copyProperties(entity, cffVo);
        }
        return ResponseUtil.success(cffVo);
    }

    @ApiOperation(nickname = "delete",value = "删除邀请函浏览信息接口")
    @LogAnnotation
    @PostMapping("/delete")
    public ResponseData delete(@Valid @RequestBody SportInvitedUserViewDeleteRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportInvitedUserViewService.deleteById(requestParam.getId());
        return ResponseUtil.success();
    }
}
