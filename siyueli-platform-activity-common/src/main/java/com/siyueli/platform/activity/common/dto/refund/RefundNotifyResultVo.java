package com.siyueli.platform.activity.common.dto.refund;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("xml")
public class RefundNotifyResultVo {

    private String return_code;

    private String return_msg;

    private String appid;

    private String mch_id;

    private String nonce_str;

    private String req_info;
}
