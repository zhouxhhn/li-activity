package com.siyueli.platform.activity.client.controller;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.util.ResponseUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class BaseController {

    protected ResponseData getErrorResponse(BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            String[] errArr = new String[result.getAllErrors().size()];
            for (int i = 0; i < result.getAllErrors().size(); i++) {
                errArr[i] = result.getAllErrors().get(i).getDefaultMessage();
            }

            String errMsg = StringUtils.join(errArr, ",");

            return ResponseUtil.build(ResponseBackCode.ERROR_PARAM_INVALID.getValue(), errMsg);


        }
        return null;
    }
}
