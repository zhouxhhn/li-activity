package com.siyueli.platform.activity.service.controller.sportmsggroup;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportmsggroup.SportMsgGroupUser;
import com.siyueli.platform.activity.common.request.sportmsggroup.*;
import com.siyueli.platform.activity.common.response.sportmsggroup.SportMsgGroupUserVo;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.sportmsggroup.SportMsgGroupUserServiceContract;
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

import javax.validation.Valid;
import java.util.Date;

@Api(tags = "消息用户组的用户管理接口")
@RestController
@RequestMapping("/sportMsgGroupUser")
public class SportMsgGroupUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportMsgGroupUserController.class);

    @Autowired
    private SportMsgGroupUserServiceContract sportMsgGroupUserService;

    @ApiOperation(nickname = "add",value = "新增消息用户组的用户接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportMsgGroupUserAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportMsgGroupUser entity = new SportMsgGroupUser();
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportMsgGroupUserService.insertAllColumn(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "update",value = "更新消息用户组的用户接口")
    @LogAnnotation
    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody SportMsgGroupUserUpdateRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportMsgGroupUser entity = sportMsgGroupUserService.selectById(requestParam.getId());
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setUpdateAt(now);

        sportMsgGroupUserService.updateAllColumnById(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "search",value = "搜索消息用户组的用户接口")
    @LogAnnotation
    @PostMapping("/search")
    public ResponseData search(@Valid @RequestBody SportMsgGroupUserSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        EntityWrapper<SportMsgGroupUser> entityWrapper = new EntityWrapper<SportMsgGroupUser>();
        Page<SportMsgGroupUser> page = new Page<SportMsgGroupUser>(requestParam.getPage(), requestParam.getSize());
        Page<SportMsgGroupUser> resultPage = sportMsgGroupUserService.selectPage(page, entityWrapper);
        try {
            PageResponse<SportMsgGroupUserVo> pageResponse = ConvertUtil.getPageResponse(resultPage, SportMsgGroupUserVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }

    @ApiOperation(nickname = "get",value = "得到消息用户组的用户接口")
    @LogAnnotation
    @PostMapping("/get")
    public ResponseData get(@Valid @RequestBody SportMsgGroupUserGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportMsgGroupUser entity = sportMsgGroupUserService.selectById(requestParam.getId());
        SportMsgGroupUserVo cffVo = null;
        if (entity != null) {
            cffVo = new SportMsgGroupUserVo();
            BeanUtils.copyProperties(entity, cffVo);
        }
        return ResponseUtil.success(cffVo);
    }

    @ApiOperation(nickname = "delete",value = "删除消息用户组的用户接口")
    @LogAnnotation
    @PostMapping("/delete")
    public ResponseData delete(@Valid @RequestBody SportMsgGroupUserDeleteRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportMsgGroupUserService.deleteById(requestParam.getId());
        return ResponseUtil.success();
    }
}
