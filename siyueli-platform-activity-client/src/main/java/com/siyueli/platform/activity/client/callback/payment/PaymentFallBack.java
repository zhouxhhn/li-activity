package com.siyueli.platform.activity.client.callback.payment;

import cn.siyue.platform.base.ResponseData;
import com.siyueli.platform.activity.client.callback.BaseServiceFallBack;
import com.siyueli.platform.activity.client.service.payment.PaymentClient;
import com.siyueli.platform.activity.client.util.XStreamUtil;
import com.siyueli.platform.activity.common.dto.payment.NotifyResultResponse;
import com.siyueli.platform.activity.common.request.payment.PaymentPayRequest;
import com.siyueli.platform.activity.common.request.payment.PaymentRefundRequest;
import com.thoughtworks.xstream.XStream;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallBack extends BaseServiceFallBack implements PaymentClient {
    @Override
    public ResponseData pay(PaymentPayRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData payNotify(String content) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData getPayResult(String orderNo) {
        return getDownGradeResponse();
    }

    @Override
    public ResponseData refund(PaymentRefundRequest requestParam) {
        return getDownGradeResponse();
    }

    @Override
    public String refundNotify(String content) {
        return getResponse("FAIL", "FAIL");
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
