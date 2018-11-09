package com.siyueli.platform.activity.client.controller.payment;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.client.controller.BaseController;
import com.siyueli.platform.activity.client.service.payment.PaymentClient;
import com.siyueli.platform.activity.common.request.payment.PaymentPayRequest;
import com.siyueli.platform.activity.common.request.payment.PaymentRefundRequest;
import com.siyueli.platform.activity.common.response.payment.GetPayResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "支付接口")
@RestController
@RequestMapping("/payment")
public class PaymentController extends BaseController {

    @Autowired
    private PaymentClient paymentClient;

    @ApiOperation(nickname = "pay",value = "支付")
    @LogAnnotation
    @PostMapping("/pay")
    public ResponseData pay(@Valid @RequestBody PaymentPayRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        return paymentClient.pay(requestParam);
    }

    @LogAnnotation
    @ApiOperation(nickname = "payNotify",value = "支付结果通知")
    @PostMapping("/payNotify")
    public String payNotify(@RequestBody String content, BindingResult result) {
        ResponseData<String> responseData = paymentClient.payNotify(content);
        String notifyResult = responseData.getData();
        return notifyResult;
    }

    @LogAnnotation
    @ApiOperation(nickname = "getPayResult",value = "得到支付结果")
    @GetMapping("/getPayResult")
    public ResponseData<GetPayResultResponse> getPayResult(String orderNo) {
        return paymentClient.getPayResult(orderNo);
    }

    @ApiOperation(nickname = "refund",value = "退款")
    @LogAnnotation
    @PostMapping("/refund")
    public ResponseData refund(@Valid @RequestBody PaymentRefundRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        return paymentClient.refund(requestParam);
    }

    @LogAnnotation
    @ApiOperation(nickname = "refundNotify",value = "退款结果通知")
    @PostMapping("/refundNotify")
    public String refundNotify(@RequestBody String content) {
        return paymentClient.refundNotify(content);
    }
}
