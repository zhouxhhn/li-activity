package com.siyueli.platform.activity.service.service.payment;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.common.request.payment.PaymentPayRequest;
import com.siyueli.platform.activity.common.request.payment.PaymentRefundRequest;
import com.siyueli.platform.activity.common.response.payment.GetPayResultResponse;
import com.siyueli.platform.activity.common.response.payment.RechargeResponse;

public interface PaymentService {

    public ResponseData<RechargeResponse> pay(PaymentPayRequest requestParam);

    public String handlePayNotifyResult(String content);

    public ResponseData<GetPayResultResponse> getPayResult(String orderNo);

    public ResponseData refund(PaymentRefundRequest requestParam);

    public String handleRefundNotifyResult(String content) throws Exception;

}
