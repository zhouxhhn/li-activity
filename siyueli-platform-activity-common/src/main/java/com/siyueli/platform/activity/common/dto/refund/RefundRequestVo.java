package com.siyueli.platform.activity.common.dto.refund;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("xml")
public class RefundRequestVo {

    private String appid;

    private String mch_id;

    private String nonce_str;

    private String sign;

    private String sign_type;

    private String transaction_id;

    private String out_trade_no;

    private String out_refund_no;

    private int total_fee;

    private int refund_fee;

    private String refund_fee_type;

    private String refund_desc;

    private String refund_account;

    private String notify_url;
}
