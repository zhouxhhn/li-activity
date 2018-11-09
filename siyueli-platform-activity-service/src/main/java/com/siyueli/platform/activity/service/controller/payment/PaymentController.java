package com.siyueli.platform.activity.service.controller.payment;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.httplog.annotation.LogAnnotation;
import com.siyueli.platform.activity.common.dto.payment.NotifyResultResponse;
import com.siyueli.platform.activity.common.request.payment.PaymentPayRequest;
import com.siyueli.platform.activity.common.request.payment.PaymentRefundRequest;
import com.siyueli.platform.activity.common.response.payment.GetPayResultResponse;
import com.siyueli.platform.activity.service.constant.ActivityServiceConstant;
import com.siyueli.platform.activity.service.controller.BaseController;
import com.siyueli.platform.activity.service.service.payment.PaymentService;
import com.siyueli.platform.activity.service.util.XStreamUtil;
import com.thoughtworks.xstream.XStream;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "支付接口")
@RestController
@RequestMapping("/payment")
public class PaymentController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @ApiOperation(nickname = "pay",value = "支付")
    @LogAnnotation
    @PostMapping("/pay")
    public ResponseData pay(@Valid @RequestBody PaymentPayRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        return paymentService.pay(requestParam);
    }

    @ApiOperation(nickname = "refund",value = "退款")
    @LogAnnotation
    @PostMapping("/refund")
    public ResponseData refund(@Valid @RequestBody PaymentRefundRequest requestParam, BindingResult result) {
        //请求的数据参数格式不正确
        if (result.hasErrors()) {
            return getErrorResponse(result);
        }

        return paymentService.refund(requestParam);
    }

    @LogAnnotation
    @ApiOperation(nickname = "payNotify",value = "支付结果通知")
    @PostMapping("/payNotify")
    public String payNotify(@RequestBody String content, BindingResult result) {
        return paymentService.handlePayNotifyResult(content);
    }

    @LogAnnotation
    @ApiOperation(nickname = "refundNotify",value = "退款结果通知")
    @PostMapping("/refundNotify")
    public String refundNotify(@RequestBody String content, BindingResult result) {
        try {
            return paymentService.handleRefundNotifyResult(content);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return getResponse(ActivityServiceConstant.PAY_FAIL, "FAIL");
        }
    }

    @LogAnnotation
    @ApiOperation(nickname = "getPayResult",value = "得到支付结果")
    @GetMapping("/getPayResult")
    public ResponseData<GetPayResultResponse> getPayResult(String orderNo) {
        return paymentService.getPayResult(orderNo);
    }

    private String getResponse(String return_code, String return_msg) {
        NotifyResultResponse resonse = new NotifyResultResponse();
        resonse.setReturn_code(return_code);
        resonse.setReturn_msg(return_msg);
        XStream xstream = XStreamUtil.getXStream(NotifyResultResponse.class);
        String xml = xstream.toXML(resonse);
        return xml;
    }
}
