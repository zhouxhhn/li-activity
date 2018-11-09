package com.siyueli.platform.activity.service.controller.sportmemberfavorites;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportmemberfavorites.SportMemberFavorites;
import com.siyueli.platform.activity.common.request.sportmemberfavorites.*;
import com.siyueli.platform.activity.common.response.sportmemberfavorites.SportMemberFavoritesVo;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.sportmemberfavorites.SportMemberFavoritesServiceContract;
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

@Api(tags = "体育活动_收藏管理接口")
@RestController
@RequestMapping("/sportMemberFavorites")
public class SportMemberFavoritesController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportMemberFavoritesController.class);

    @Autowired
    private SportMemberFavoritesServiceContract sportMemberFavoritesService;

    @ApiOperation(nickname = "add",value = "新增体育活动_收藏接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportMemberFavoritesAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportMemberFavorites entity = new SportMemberFavorites();
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setCreateAt(now);
        entity.setUpdateAt(now);

        sportMemberFavoritesService.insertAllColumn(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "update",value = "更新体育活动_收藏接口")
    @LogAnnotation
    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody SportMemberFavoritesUpdateRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportMemberFavorites entity = sportMemberFavoritesService.selectById(requestParam.getId());
        BeanUtils.copyProperties(requestParam, entity);

        Date now = new Date();
        entity.setUpdateAt(now);

        sportMemberFavoritesService.updateAllColumnById(entity);
        return ResponseUtil.success();
    }

    @ApiOperation(nickname = "search",value = "搜索体育活动_收藏接口")
    @LogAnnotation
    @PostMapping("/search")
    public ResponseData search(@Valid @RequestBody SportMemberFavoritesSearchRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        EntityWrapper<SportMemberFavorites> entityWrapper = new EntityWrapper<SportMemberFavorites>();
        Page<SportMemberFavorites> page = new Page<SportMemberFavorites>(requestParam.getPage(), requestParam.getSize());
        Page<SportMemberFavorites> resultPage = sportMemberFavoritesService.selectPage(page, entityWrapper);
        try {
            PageResponse<SportMemberFavoritesVo> pageResponse = ConvertUtil.getPageResponse(resultPage, SportMemberFavoritesVo.class);
            return ResponseUtil.success(pageResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseUtil.fail();
    }

    @ApiOperation(nickname = "get",value = "得到体育活动_收藏接口")
    @LogAnnotation
    @PostMapping("/get")
    public ResponseData get(@Valid @RequestBody SportMemberFavoritesGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        SportMemberFavorites entity = sportMemberFavoritesService.selectById(requestParam.getId());
        SportMemberFavoritesVo cffVo = null;
        if (entity != null) {
            cffVo = new SportMemberFavoritesVo();
            BeanUtils.copyProperties(entity, cffVo);
        }
        return ResponseUtil.success(cffVo);
    }

    @ApiOperation(nickname = "delete",value = "删除体育活动_收藏接口")
    @LogAnnotation
    @PostMapping("/delete")
    public ResponseData delete(@Valid @RequestBody SportMemberFavoritesDeleteRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        sportMemberFavoritesService.deleteById(requestParam.getId());
        return ResponseUtil.success();
    }
}
