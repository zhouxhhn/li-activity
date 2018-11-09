package com.siyueli.platform.activity.service.controller.sportactivity;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivitySignup;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivitySignupVo;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityOrderServiceContract;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivitySignupServiceContract;
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

@Api(tags = "活动报名管理接口")
@RestController
@RequestMapping("/sportActivitySignup")
public class SportActivitySignupController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportActivitySignupController.class);

    @Autowired
    private SportActivitySignupServiceContract sportActivitySignupService;



    @ApiOperation(nickname = "add",value = "新增活动报名接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivitySignupAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        String orderNo = sportActivitySignupService.signUp(requestParam);
        return ResponseUtil.success(orderNo);
    }

    @ApiOperation(nickname = "update",value = "更新活动报名接口")
    @LogAnnotation
    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody SportActivitySignupUpdateRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivitySignup entity = sportActivitySignupService.selectById(requestParam.getId());
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setUpdateAt(now);

        sportActivitySignupService.updateAllColumnById(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "search",value = "搜索活动报名接口")
    @LogAnnotation
    @PostMapping("/search")
    public ResponseData search(@Valid @RequestBody SportActivitySignupSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        EntityWrapper<SportActivitySignup> entityWrapper = new EntityWrapper<SportActivitySignup>();
        Page<SportActivitySignup> page = new Page<SportActivitySignup>(requestParam.getPage(), requestParam.getSize());
        Page<SportActivitySignup> resultPage = sportActivitySignupService.selectPage(page, entityWrapper);
        try {
            PageResponse<SportActivitySignupVo> pageResponse = ConvertUtil.getPageResponse(resultPage, SportActivitySignupVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }

    @ApiOperation(nickname = "get",value = "得到活动报名接口")
    @LogAnnotation
    @PostMapping("/get")
    public ResponseData get(@Valid @RequestBody SportActivitySignupGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivitySignup entity = sportActivitySignupService.selectById(requestParam.getId());
        SportActivitySignupVo cffVo = null;
        if (entity != null) {
            cffVo = new SportActivitySignupVo();
            BeanUtils.copyProperties(entity, cffVo);
        }
        return ResponseUtil.success(cffVo);
    }

    @ApiOperation(nickname = "delete",value = "删除活动报名接口")
    @LogAnnotation
    @PostMapping("/delete")
    public ResponseData delete(@Valid @RequestBody SportActivitySignupDeleteRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportActivitySignupService.deleteById(requestParam.getId());
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "updateStatus",value = "更新活动报名状态接口")
    @LogAnnotation
    @PostMapping("/updateStatus")
    public ResponseData updateStatus(@Valid @RequestBody SportActivitySignupUpdateStatusRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportActivitySignupService.updateStatus(requestParam);
        return ResponseUtil.success();
    }
}
