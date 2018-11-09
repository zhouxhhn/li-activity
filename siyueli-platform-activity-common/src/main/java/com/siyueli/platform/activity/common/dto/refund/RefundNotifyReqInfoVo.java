package com.siyueli.platform.activity.common.dto.refund;

import lombok.Data;

@Data
public class RefundNotifyReqInfoVo {

    private String transaction_id;

    private String out_trade_no;

    private String refund_id;

    private String out_refund_no;

    private int total_fee;

    private int settlement_total_fee;

    private int refund_fee;

    private int settlement_refund_fee;

    private String refund_status;

    private String success_time;

    private String refund_recv_accout;

    private String refund_account;

    private String refund_request_source;
}
