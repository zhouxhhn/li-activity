package com.siyueli.platform.activity.service.service.payment;

import com.siyueli.platform.activity.common.dto.payment.OrderQueryResultVo;
import com.siyueli.platform.activity.common.dto.payment.OrderQueryVo;
import com.siyueli.platform.activity.common.dto.refund.RefundQueryResultVo;
import com.siyueli.platform.activity.common.dto.refund.RefundResultVo;

public interface MiniProgramPayService {


    public OrderQueryResultVo orderQuery(OrderQueryVo oq);

    public OrderQueryResultVo orderQuery(String out_trade_no);

    public OrderQueryResultVo orderQuery(OrderQueryVo oq, String key);

    public RefundResultVo refund(String orderNo);

    public RefundQueryResultVo refundQuery(String refundOrderNo);
}
