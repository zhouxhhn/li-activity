package com.siyueli.platform.activity.client.controller.front;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportmemberfavorites.SportMemberFavoritesClient;
import com.siyueli.platform.activity.common.request.sportmemberfavorites.SportMemberFavoritesAddRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "前台_体育活动_收藏管理接口")
@RestController
@RequestMapping("/sportMemberFavoritesFront")
public class SportMemberFavoritesFrontController extends BaseController {

    @Autowired
    private SportMemberFavoritesClient sportMemberFavoritesClient;

    @ApiOperation(nickname = "addSportMemberFavoritesFront",value = "新增体育活动_收藏接口")
    @LogAnnotation
    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody SportMemberFavoritesAddRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }
        return sportMemberFavoritesClient.add(requestParam);
    }
}
