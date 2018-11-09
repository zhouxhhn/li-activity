package com.siyueli.platform.activity.service.service.payment.impl;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.util.ResponseUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.siyueli.platform.activity.common.dto.payment.*;
import com.siyueli.platform.activity.common.dto.refund.RefundNotifyReqInfoVo;
import com.siyueli.platform.activity.common.dto.refund.RefundNotifyResultVo;
import com.siyueli.platform.activity.common.dto.refund.RefundResultVo;
import com.siyueli.platform.activity.common.entity.member.MemberUser;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityOrder;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityRefundOrder;
import com.siyueli.platform.activity.common.request.payment.PaymentPayRequest;
import com.siyueli.platform.activity.common.request.payment.PaymentRefundRequest;
import com.siyueli.platform.activity.common.response.payment.GetPayResultResponse;
import com.siyueli.platform.activity.common.response.payment.RechargeResponse;
import com.siyueli.platform.activity.common.response.payment.RefundResponse;
import com.siyueli.platform.activity.service.config.ActivityConfig;
import com.siyueli.platform.activity.service.config.WeixinConfig;
import com.siyueli.platform.activity.service.constant.ActivityServiceConstant;
import com.siyueli.platform.activity.service.constant.OrderConstant;
import com.siyueli.platform.activity.service.constant.RefundOrderConstant;
import com.siyueli.platform.activity.service.constant.WeixinUrl;
import com.siyueli.platform.activity.service.service.member.MemberUserServiceContract;
import com.siyueli.platform.activity.service.service.payment.MiniProgramPayService;
import com.siyueli.platform.activity.service.service.payment.PaymentService;
import com.siyueli.platform.activity.service.service.redis.JedisClusterService;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityOrderServiceContract;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityRefundOrderServiceContract;
import com.siyueli.platform.activity.service.util.*;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private WeixinConfig weixinConfig;

    @Autowired
    private JedisClusterService jedisClusterService;

    @Autowired
    private MemberUserServiceContract memberUserServiceContract;

    @Autowired
    private SportActivityOrderServiceContract sportActivityOrderServiceContract;

    @Autowired
    private MiniProgramPayService miniProgramPayService;

    @Autowired
    private SportActivityRefundOrderServiceContract sportActivityRefundOrderServiceContract;

    @Autowired
    private ActivityConfig activityConfig;

    @Override
    public ResponseData<RechargeResponse> pay(PaymentPayRequest requestParam) {
        String url = WeixinUrl.UNIFIED_ORDER_URL;
        String notifyUrl = activityConfig.getApi_url() + weixinConfig.getPay_notify_url();
        String openid = null;
        MemberUser user = getUser();
        if (user != null) {
            openid = user.getUnnitId();
        }

        if (StringUtils.isEmpty(openid)) {
            return ResponseData.build(ResponseBackCode.CUSTOM_NOTIFY.getValue(), "找不到openid");
        }

        SportActivityOrder sportActivityOrder = getOrder(requestParam.getOrderNo());
        if (sportActivityOrder == null) {
            return ResponseUtil.fail("找不到订单");
        }

        String appid = weixinConfig.getAppid();
        String mch_id = weixinConfig.getMch_id();
        String key = weixinConfig.getKey();
        String nonceStr = RandomStringUtil.getRandomString(32);

        String out_trade_no = requestParam.getOrderNo();
        String body = "recharge";
        String signType = "MD5";

        UnifiedOrderVo vo = new UnifiedOrderVo();
        vo.setAppid(appid);
        vo.setMch_id(mch_id);
        vo.setDevice_info("WEB");
        vo.setNonce_str(nonceStr);
        vo.setSign_type(signType);
        vo.setBody(body);
        vo.setOut_trade_no(out_trade_no);
        vo.setFee_type("CNY");
        int amount = CurrencyUtil.yuanToFen(sportActivityOrder.getAmount()).intValue();
        String totalFee = String.valueOf(amount);
        vo.setTotal_fee(totalFee);
        vo.setNotify_url(notifyUrl);
        vo.setTrade_type("JSAPI");
        vo.setOpenid(openid);

        /*// 空值
        vo.setDetail(null);
        vo.setAttach(null);
        // 空值
        vo.setSpbill_create_ip(null);
        vo.setTime_start(null);
        vo.setTime_expire(null);
        vo.setGoods_tag(null);
        // 空值
        vo.setProduct_id(null);
        vo.setLimit_pay(null);*/

        Map map = null;
        try {
            map = ConvertUtil.objectToMap(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map sortedMap = MapSortUtil.sortMapByKey(map);
        String sign = ConvertUtil.getSignatureParams(sortedMap);
        System.out.println("sign: " + sign);
        sign = sign + "&key=" + key;
        System.out.println("sign2: " + sign);

        sign = MD5Maker.getMD5(sign);
        vo.setSign(sign);

        XStream xstream = XStreamUtil.getXStream(UnifiedOrderVo.class);
        String xml = xstream.toXML(vo);

        //System.out.println("xml内容: ");
        //System.out.println(xml);

        String content = HttpUtils.httpsPostRequest(url, xml);

        //System.out.println("content内容：" + content);

        UnifiedOrderResultVo result = getResult(content);
        RechargeResponse resp = new RechargeResponse();

        long timeStamp = System.currentTimeMillis() / 1000;
        resp.setNonceStr(nonceStr);
        resp.setTimeStamp(String.valueOf(timeStamp));
        resp.setSignType(signType);
        resp.setPkg("prepay_id=" + result.getPrepay_id());
        resp.setOrderNo(out_trade_no);
        String paySign = getResponsePaySign(resp);
        resp.setPaySign(paySign);

        ResponseData data = ResponseUtil.success();
        data.setData(resp);
        return data;
    }

    private SportActivityOrder getOrder(String orderNo) {
        EntityWrapper<SportActivityOrder> entityWrapper = new EntityWrapper<SportActivityOrder>();
        entityWrapper.eq("order_no", orderNo);
        SportActivityOrder sportActivityOrder = sportActivityOrderServiceContract.selectOne(entityWrapper);
        return sportActivityOrder;
    }

    private NotifyResultVo getNotifyResult(String content) {
        XStream xstream = XStreamUtil.getXStream(NotifyResultVo.class);
        NotifyResultVo result = (NotifyResultVo)xstream.fromXML(content);
        return result;
    }

    private UnifiedOrderResultVo getResult(String content) {
        XStream xstream = XStreamUtil.getXStream(UnifiedOrderResultVo.class);
        UnifiedOrderResultVo result = (UnifiedOrderResultVo)xstream.fromXML(content);
        return result;
    }

    private RefundNotifyResultVo getRefundNotifyResult(String content) {
        XStream xstream = XStreamUtil.getXStream(RefundNotifyResultVo.class);
        RefundNotifyResultVo result = (RefundNotifyResultVo)xstream.fromXML(content);
        return result;
    }

    private RefundNotifyReqInfoVo getRefundNotifyReqInfo(String content) {
        XStream xstream = XStreamUtil.getXStream(RefundNotifyReqInfoVo.class);
        RefundNotifyReqInfoVo result = (RefundNotifyReqInfoVo)xstream.fromXML(content);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String handlePayNotifyResult(String content) {
        NotifyResultVo notifyResult = getNotifyResult(content);

        if (notifyResult != null && StringUtils.isNotEmpty(notifyResult.getSign())) {
            String sign = getSign(notifyResult);
            //通过验签
            if (notifyResult.getSign().equals(sign)) {
                LOGGER.info("验签通过");
                LOGGER.info("回调通知结果：" + notifyResult.getOut_trade_no() + "：" + notifyResult.getReturn_code());

                EntityWrapper<SportActivityOrder> entityWrapper = new EntityWrapper<SportActivityOrder>();
                entityWrapper.eq("order_no", notifyResult.getOut_trade_no());
                SportActivityOrder rechargeOrder = sportActivityOrderServiceContract.selectOne(entityWrapper);
                if (rechargeOrder != null) {
                    if (ActivityServiceConstant.PAY_SUCCESS.equals(notifyResult.getReturn_code())) {
                        LOGGER.info("rechargeOrder.getAmount(): " + rechargeOrder.getAmount());
                        LOGGER.info("new BigDecimal(notifyResult.getTotal_fee()): " + new BigDecimal(notifyResult.getTotal_fee()));
                        BigDecimal fenAmount = CurrencyUtil.yuanToFen(rechargeOrder.getAmount());
                        if (fenAmount.compareTo(new BigDecimal(notifyResult.getTotal_fee())) == 0) {
                            OrderQueryResultVo orderQueryResult = miniProgramPayService.orderQuery(notifyResult.getOut_trade_no());
                            if (orderQueryResult != null && ActivityServiceConstant.PAY_SUCCESS.equals(orderQueryResult.getReturn_code())
                                    && ActivityServiceConstant.PAY_SUCCESS.equals(orderQueryResult.getResult_code())
                                    && ActivityServiceConstant.PAY_SUCCESS.equals(orderQueryResult.getTrade_state())
                                    && fenAmount.compareTo(new BigDecimal(orderQueryResult.getTotal_fee())) == 0) {

                                return updateOrderAndResponse(rechargeOrder, OrderConstant.ORDER_STATUS_PAID, "OK", notifyResult);
                            } else {
                                return updateOrderAndResponse(rechargeOrder, OrderConstant.ORDER_STATUS_PAYMENT_FAIL, "查询的订单状态与通知结果的订单状态不一致", notifyResult);
                            }


                        } else {
                            return updateOrderAndResponse(rechargeOrder, OrderConstant.ORDER_STATUS_PAYMENT_FAIL, "订单金额不对", notifyResult);
                        }
                    } else {
                        return updateOrderAndResponse(rechargeOrder, OrderConstant.ORDER_STATUS_PAYMENT_FAIL, "支付失败", notifyResult);
                    }
                } else {
                    return getResponse("FAIL", "找不到订单");
                }

            }
        }
        // 失败
        return getResponse("FAIL", "验签失败");
    }

    private String updateOrderAndResponse(SportActivityOrder rechargeOrder, int status, String return_msg, NotifyResultVo notifyResult) {
        updateOrder(rechargeOrder, status, return_msg, notifyResult);
        return getResponse(getReturn_code(status), return_msg);
    }

    private String getReturn_code(int status) {
        if (OrderConstant.ORDER_STATUS_PAID == status) {
            return "SUCCESS";
        }
        return "FAIL";
    }


    private void updateOrder(SportActivityOrder sportActivityOrder, int status, String return_msg, NotifyResultVo notifyResult) {
        // 已经支付成功，不再处理
        if (OrderConstant.ORDER_STATUS_PAID == sportActivityOrder.getStatus()) {
            System.out.println("已经支付成功，不再处理: " + sportActivityOrder.getOrderNo());
            return;
        }

        Date now = new Date();
        sportActivityOrder.setStatus(status);
        sportActivityOrder.setUpdateAt(now);
        sportActivityOrder.setRemark(return_msg + "[" + notifyResult.getReturn_msg() + "]");
        sportActivityOrderServiceContract.updateAllColumnById(sportActivityOrder);

    }

    @Override
    public ResponseData<GetPayResultResponse> getPayResult(String orderNo) {
        EntityWrapper<SportActivityOrder> entityWrapper = new EntityWrapper<SportActivityOrder>();
        entityWrapper.eq("order_no", orderNo);
        SportActivityOrder sportActivityOrder = sportActivityOrderServiceContract.selectOne(entityWrapper);
        if (sportActivityOrder != null) {
            GetPayResultResponse resp = new GetPayResultResponse();
            resp.setOrderNo(orderNo);
            resp.setStatus(sportActivityOrder.getStatus());
            ResponseData data = ResponseUtil.success();
            data.setData(resp);
            return data;
        }
        return ResponseData.build(ResponseBackCode.CUSTOM_NOTIFY.getValue(), "找不到订单");
    }

    @Override
    public ResponseData refund(PaymentRefundRequest requestParam) {
        RefundResultVo refundResultVo = miniProgramPayService.refund(requestParam.getOrderNo());

        RefundResponse refundResponse = new RefundResponse();
        refundResponse.setReturn_code(refundResultVo.getReturn_code());
        refundResponse.setReturn_msg(refundResultVo.getReturn_msg());
        return ResponseUtil.success(refundResponse);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String handleRefundNotifyResult(String content) throws Exception {
        RefundNotifyResultVo refundNotifyResultVo = getRefundNotifyResult(content);

        if (RefundOrderConstant.REFUND_ORDER_STATUS_SUCCESS.equals(refundNotifyResultVo.getReturn_code())) {
            String reqInfo = refundNotifyResultVo.getReq_info();
            if (StringUtils.isNotEmpty(reqInfo)) {
                byte[] reqInfoByte = Base64Util.decodeBase64(reqInfo);
                String key = weixinConfig.getKey();
                String md5Key = MD5Maker.getMD5(key);
                String reqInfoContent = new String(reqInfoByte, "UTF-8");
                String decryptReqInfo = AESUtil.decrypt(reqInfoContent, md5Key);
                RefundNotifyReqInfoVo refundNotifyReqInfoVo = getRefundNotifyReqInfo(decryptReqInfo);

                EntityWrapper<SportActivityRefundOrder> entityWrapper = new EntityWrapper<SportActivityRefundOrder>();
                entityWrapper.eq("refund_order_no", refundNotifyReqInfoVo.getOut_refund_no());
                SportActivityRefundOrder sportActivityRefundOrder = sportActivityRefundOrderServiceContract.selectOne(entityWrapper);

                // 退款成功
                if ("SUCCESS".equals(refundNotifyReqInfoVo.getRefund_status())) {
                    sportActivityRefundOrder.setStatus(RefundOrderConstant.REFUND_ORDER_STATUS_SUCCESS);
                } else if ("CHANGE".equals(refundNotifyReqInfoVo.getRefund_status())) { // 退款异常
                    sportActivityRefundOrder.setStatus(RefundOrderConstant.REFUND_ORDER_STATUS_FAIL);
                } else if ("REFUNDCLOSE".equals(refundNotifyReqInfoVo.getRefund_status())) { // 退款关闭
                    sportActivityRefundOrder.setStatus(RefundOrderConstant.REFUND_ORDER_STATUS_FAIL);
                }
                Date now = new Date();
                sportActivityRefundOrder.setUpdateAt(now);
                sportActivityRefundOrderServiceContract.updateAllColumnById(sportActivityRefundOrder);

                EntityWrapper<SportActivityOrder> orderEntityWrapper = new EntityWrapper<SportActivityOrder>();
                orderEntityWrapper.eq("id", sportActivityRefundOrder.getOrderId());
                SportActivityOrder sportActivityOrder = sportActivityOrderServiceContract.selectOne(orderEntityWrapper);
                sportActivityOrder.setUpdateAt(now);
                sportActivityOrder.setStatus(OrderConstant.ORDER_STATUS_REFUNDED);
                sportActivityOrderServiceContract.updateAllColumnById(sportActivityOrder);

                return getResponse(ActivityServiceConstant.PAY_SUCCESS, "OK");


            }
        } else {

        }

        return getResponse(ActivityServiceConstant.PAY_FAIL, "FAIL");
    }

    private String getSign(NotifyResultVo result) {
        NotifyResultVo signResult = new NotifyResultVo();
        BeanUtils.copyProperties(result, signResult);
        signResult.setSign(null);

        Map map = null;
        try {
            map = ConvertUtil.objectToMap(signResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map sortedMap = MapSortUtil.sortMapByKey(map);
        String sign = ConvertUtil.getSignatureParams(sortedMap);
        sign = sign + "&key=" + weixinConfig.getKey();
        sign = MD5Maker.getMD5(sign);
        return sign;
    }

    private String getResponsePaySign(RechargeResponse resp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appId", weixinConfig.getAppid());
        map.put("timeStamp", resp.getTimeStamp());
        map.put("nonceStr", resp.getNonceStr());
        map.put("package", resp.getPkg());
        map.put("signType", resp.getSignType());

        Map sortedMap = MapSortUtil.sortMapByKey(map);
        String sign = ConvertUtil.getSignatureParams(sortedMap);
        sign = sign + "&key=" + weixinConfig.getKey();
        sign = MD5Maker.getMD5(sign);
        return sign;
    }

    private String getResponse(String return_code, String return_msg) {
        NotifyResultResponse resonse = new NotifyResultResponse();
        resonse.setReturn_code(return_code);
        resonse.setReturn_msg(return_msg);
        XStream xstream = XStreamUtil.getXStream(NotifyResultResponse.class);
        String xml = xstream.toXML(resonse);
        return xml;
    }

    private MemberUser getUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        String userId = null;
        if (StringUtils.isNotEmpty(token)) {
            userId = jedisClusterService.get(ActivityServiceConstant.REDIS_USER_SESSION_KEY_FRONT + ":" + token);
        }
        MemberUser user = null;
        if (StringUtils.isNotEmpty(userId)) {
            user = memberUserServiceContract.selectById(userId);
            return user;
        }

        return null;
    }

    private Long getUserId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        String userId = null;
        if (StringUtils.isNotEmpty(token)) {
            userId = jedisClusterService.get(ActivityServiceConstant.REDIS_USER_SESSION_KEY_FRONT + ":" + token);
        }
        MemberUser user = null;
        if (StringUtils.isNotEmpty(userId)) {
            return new Long(userId);
        }
        return null;
    }
}
