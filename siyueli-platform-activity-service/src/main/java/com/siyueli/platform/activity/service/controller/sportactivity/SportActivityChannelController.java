package com.siyueli.platform.activity.service.controller.sportactivity;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityChannel;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityChannelVo;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityChannelServiceContract;
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

@Api(tags = "活动渠道管理接口")
@RestController
@RequestMapping("/sportActivityChannel")
public class SportActivityChannelController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportActivityChannelController.class);

    @Autowired
    private SportActivityChannelServiceContract sportActivityChannelService;

    @ApiOperation(nickname = "add",value = "新增活动渠道接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityChannelAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityChannel entity = new SportActivityChannel();
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportActivityChannelService.insertAllColumn(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "update",value = "更新活动渠道接口")
    @LogAnnotation
    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody SportActivityChannelUpdateRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityChannel entity = sportActivityChannelService.selectById(requestParam.getId());
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setUpdateAt(now);

        sportActivityChannelService.updateAllColumnById(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "search",value = "搜索活动渠道接口")
    @LogAnnotation
    @PostMapping("/search")
    public ResponseData search(@Valid @RequestBody SportActivityChannelSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        EntityWrapper<SportActivityChannel> entityWrapper = new EntityWrapper<SportActivityChannel>();
        Page<SportActivityChannel> page = new Page<SportActivityChannel>(requestParam.getPage(), requestParam.getSize());
        Page<SportActivityChannel> resultPage = sportActivityChannelService.selectPage(page, entityWrapper);
        try {
            PageResponse<SportActivityChannelVo> pageResponse = ConvertUtil.getPageResponse(resultPage, SportActivityChannelVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }

    @ApiOperation(nickname = "get",value = "得到活动渠道接口")
    @LogAnnotation
    @PostMapping("/get")
    public ResponseData get(@Valid @RequestBody SportActivityChannelGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityChannel entity = sportActivityChannelService.selectById(requestParam.getId());
        SportActivityChannelVo cffVo = null;
        if (entity != null) {
            cffVo = new SportActivityChannelVo();
            BeanUtils.copyProperties(entity, cffVo);
        }
        return ResponseUtil.success(cffVo);
    }

    @ApiOperation(nickname = "delete",value = "删除活动渠道接口")
    @LogAnnotation
    @PostMapping("/delete")
    public ResponseData delete(@Valid @RequestBody SportActivityChannelDeleteRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportActivityChannelService.deleteById(requestParam.getId());
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "updateStatus",value = "更新活动渠道状态接口")
    @LogAnnotation
    @PostMapping("/updateStatus")
    public ResponseData updateStatus(@Valid @RequestBody SportActivityChannelUpdateStatusRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportActivityChannelService.updateStatus(requestParam);
        return ResponseUtil.success();
    }


}
