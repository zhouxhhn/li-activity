package com.siyueli.platform.activity.service.controller.sportactivity;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityOrder;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityOrderVo;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityOrderServiceContract;
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

@Api(tags = "活动报名订单管理接口")
@RestController
@RequestMapping("/sportActivityOrder")
public class SportActivityOrderController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportActivityOrderController.class);

    @Autowired
    private SportActivityOrderServiceContract sportActivityOrderService;

    @ApiOperation(nickname = "add",value = "新增活动报名订单接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityOrderAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityOrder entity = new SportActivityOrder();
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportActivityOrderService.insertAllColumn(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "update",value = "更新活动报名订单接口")
    @LogAnnotation
    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody SportActivityOrderUpdateRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityOrder entity = sportActivityOrderService.selectById(requestParam.getId());
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setUpdateAt(now);

        sportActivityOrderService.updateAllColumnById(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "search",value = "搜索活动报名订单接口")
    @LogAnnotation
    @PostMapping("/search")
    public ResponseData search(@Valid @RequestBody SportActivityOrderSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        EntityWrapper<SportActivityOrder> entityWrapper = new EntityWrapper<SportActivityOrder>();
        Page<SportActivityOrder> page = new Page<SportActivityOrder>(requestParam.getPage(), requestParam.getSize());
        Page<SportActivityOrder> resultPage = sportActivityOrderService.selectPage(page, entityWrapper);
        try {
            PageResponse<SportActivityOrderVo> pageResponse = ConvertUtil.getPageResponse(resultPage, SportActivityOrderVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }

    @ApiOperation(nickname = "get",value = "得到活动报名订单接口")
    @LogAnnotation
    @PostMapping("/get")
    public ResponseData get(@Valid @RequestBody SportActivityOrderGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityOrder entity = sportActivityOrderService.selectById(requestParam.getId());
        SportActivityOrderVo cffVo = null;
        if (entity != null) {
            cffVo = new SportActivityOrderVo();
            BeanUtils.copyProperties(entity, cffVo);
        }
        return ResponseUtil.success(cffVo);
    }

    @ApiOperation(nickname = "delete",value = "删除活动报名订单接口")
    @LogAnnotation
    @PostMapping("/delete")
    public ResponseData delete(@Valid @RequestBody SportActivityOrderDeleteRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportActivityOrderService.deleteById(requestParam.getId());
        return ResponseUtil.success();
    }
}
