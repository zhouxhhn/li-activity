package com.siyueli.platform.activity.service.controller.sportactivity;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityViewStatistics;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityViewStatisticsVo;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityViewStatisticsServiceContract;
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

@Api(tags = "活动浏览统计管理接口")
@RestController
@RequestMapping("/sportActivityViewStatistics")
public class SportActivityViewStatisticsController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportActivityViewStatisticsController.class);

    @Autowired
    private SportActivityViewStatisticsServiceContract sportActivityViewStatisticsService;

    @ApiOperation(nickname = "add",value = "新增活动浏览统计接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityViewStatisticsAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityViewStatistics entity = new SportActivityViewStatistics();
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportActivityViewStatisticsService.insertAllColumn(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "update",value = "更新活动浏览统计接口")
    @LogAnnotation
    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody SportActivityViewStatisticsUpdateRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityViewStatistics entity = sportActivityViewStatisticsService.selectById(requestParam.getId());
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setUpdateAt(now);

        sportActivityViewStatisticsService.updateAllColumnById(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "search",value = "搜索活动浏览统计接口")
    @LogAnnotation
    @PostMapping("/search")
    public ResponseData search(@Valid @RequestBody SportActivityViewStatisticsSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        EntityWrapper<SportActivityViewStatistics> entityWrapper = new EntityWrapper<SportActivityViewStatistics>();
        Page<SportActivityViewStatistics> page = new Page<SportActivityViewStatistics>(requestParam.getPage(), requestParam.getSize());
        Page<SportActivityViewStatistics> resultPage = sportActivityViewStatisticsService.selectPage(page, entityWrapper);
        try {
            PageResponse<SportActivityViewStatisticsVo> pageResponse = ConvertUtil.getPageResponse(resultPage, SportActivityViewStatisticsVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }

    @ApiOperation(nickname = "get",value = "得到活动浏览统计接口")
    @LogAnnotation
    @PostMapping("/get")
    public ResponseData get(@Valid @RequestBody SportActivityViewStatisticsGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivityViewStatistics entity = sportActivityViewStatisticsService.selectById(requestParam.getId());
        SportActivityViewStatisticsVo cffVo = null;
        if (entity != null) {
            cffVo = new SportActivityViewStatisticsVo();
            BeanUtils.copyProperties(entity, cffVo);
        }
        return ResponseUtil.success(cffVo);
    }

    @ApiOperation(nickname = "delete",value = "删除活动浏览统计接口")
    @LogAnnotation
    @PostMapping("/delete")
    public ResponseData delete(@Valid @RequestBody SportActivityViewStatisticsDeleteRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportActivityViewStatisticsService.deleteById(requestParam.getId());
        return ResponseUtil.success();
    }
}
