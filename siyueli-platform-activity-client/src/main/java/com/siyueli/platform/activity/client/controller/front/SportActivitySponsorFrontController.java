package com.siyueli.platform.activity.client.controller.front;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.sportactivity.SportActivitySponsorClient;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySponsorGetRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "前台_体育活动_主办方管理接口")
@RestController
@RequestMapping("/sportActivitySponsorFront")
public class SportActivitySponsorFrontController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SportActivitySponsorFrontController.class);

    @Autowired
    private SportActivitySponsorClient sportActivitySponsorClient;

    @ApiOperation(nickname = "getSportActivitySponsor",value = "得到体育活动_主办方接口")
    @LogAnnotation
    @GetMapping("/get")
    public ResponseData get(@Valid @RequestBody SportActivitySponsorGetRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        return sportActivitySponsorClient.get(requestParam);
    }
}
