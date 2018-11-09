package com.siyueli.platform.activity.service.controller.sportactivity;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivity;
import com.siyueli.platform.activity.common.request.sportactivity.*;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityVo;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityServiceContract;
import com.siyueli.platform.activity.service.util.ConvertUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
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
import java.util.List;

@Api(tags = "体育活动管理接口")
@RestController
@RequestMapping("/sportActivity")
public class SportActivityController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportActivityController.class);

    @Autowired
    private SportActivityServiceContract sportActivityService;

    @ApiOperation(nickname = "add",value = "新增体育活动接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportActivityAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivity entity = new SportActivity();
        BeanUtils.copyProperties(requestParam, entity);

        String siteProvince = requestParam.getSiteProvince();
        String siteCity = requestParam.getSiteCity();
        String siteArea = requestParam.getSiteArea();
        if (StringUtils.isNotEmpty(siteProvince)) {
            entity.setSiteProvince(new Long(siteProvince));
        }
        if (StringUtils.isNotEmpty(siteCity)) {
            entity.setSiteCity(new Long(siteCity));
        }
        if (StringUtils.isNotEmpty(siteArea)) {
            entity.setSiteArea(new Long(siteArea));
        }


        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportActivityService.insertAllColumn(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "update",value = "更新体育活动接口")
    @LogAnnotation
    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody SportActivityUpdateRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivity entity = sportActivityService.selectById(requestParam.getId());
        BeanUtils.copyProperties(requestParam, entity);

        String siteProvince = requestParam.getSiteProvince();
        String siteCity = requestParam.getSiteCity();
        String siteArea = requestParam.getSiteArea();
        if (StringUtils.isNotEmpty(siteProvince)) {
            entity.setSiteProvince(new Long(siteProvince));
        }
        if (StringUtils.isNotEmpty(siteCity)) {
            entity.setSiteCity(new Long(siteCity));
        }
        if (StringUtils.isNotEmpty(siteArea)) {
            entity.setSiteArea(new Long(siteArea));
        }

        Date now = new Date();
        entity.setUpdateAt(now);

        sportActivityService.updateAllColumnById(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "search",value = "搜索体育活动接口")
    @LogAnnotation
    @PostMapping("/search")
    public ResponseData search(@Valid @RequestBody SportActivitySearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        /*EntityWrapper<SportActivity> entityWrapper = new EntityWrapper<SportActivity>();
        Page<SportActivity> page = new Page<SportActivity>(requestParam.getPage(), requestParam.getSize());
        Page<SportActivity> resultPage = sportActivityService.selectPage(page, entityWrapper);
        try {
            PageResponse<SportActivityVo> pageResponse = ConvertUtil.getPageResponse(resultPage, SportActivityVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();*/

        PageResponse<SportActivityVo> pageResponse = sportActivityService.search(requestParam);
        return ResponseUtil.success(pageResponse);
    }

    @ApiOperation(nickname = "get",value = "得到体育活动接口")
    @LogAnnotation
    @PostMapping("/get")
    public ResponseData get(@Valid @RequestBody SportActivityGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportActivity entity = sportActivityService.selectById(requestParam.getId());
        SportActivityVo cffVo = null;
        if (entity != null) {
            cffVo = new SportActivityVo();
            BeanUtils.copyProperties(entity, cffVo);
        }
        return ResponseUtil.success(cffVo);
    }

    @ApiOperation(nickname = "delete",value = "删除体育活动接口")
    @LogAnnotation
    @PostMapping("/delete")
    public ResponseData delete(@Valid @RequestBody SportActivityDeleteRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportActivityService.deleteById(requestParam.getId());
        return ResponseUtil.success();
    }
}
