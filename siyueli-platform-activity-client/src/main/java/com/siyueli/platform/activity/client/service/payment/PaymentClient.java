package com.siyueli.platform.activity.client.service.payment;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.payment.PaymentFallBack;
import com.siyueli.platform.activity.common.request.payment.PaymentPayRequest;
import com.siyueli.platform.activity.common.request.payment.PaymentRefundRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "siyueli-activity-service", fallback = PaymentFallBack.class)
public interface PaymentClient {

    @RequestMapping(value = "/payment/pay", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData pay(@RequestBody PaymentPayRequest requestParam);

    @RequestMapping(value = "/payment/payNotify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData<String> payNotify(@RequestBody String content);

    @RequestMapping(value = "/payment/getPayResult", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData getPayResult(@Param("orderNo") String orderNo);

    @RequestMapping(value = "/payment/refund", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseData refund(@RequestBody PaymentRefundRequest requestParam);

    @RequestMapping(value = "/payment/refundNotify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    String refundNotify(@RequestBody String content);

}
