package com.siyueli.platform.activity.service.service.payment.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.siyueli.platform.activity.common.dto.payment.OrderQueryResultVo;
import com.siyueli.platform.activity.common.dto.payment.OrderQueryVo;
import com.siyueli.platform.activity.common.dto.refund.RefundQueryRequestVo;
import com.siyueli.platform.activity.common.dto.refund.RefundQueryResultVo;
import com.siyueli.platform.activity.common.dto.refund.RefundRequestVo;
import com.siyueli.platform.activity.common.dto.refund.RefundResultVo;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityOrder;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityRefundOrder;
import com.siyueli.platform.activity.service.config.ActivityConfig;
import com.siyueli.platform.activity.service.config.WeixinConfig;
import com.siyueli.platform.activity.service.constant.OrderConstant;
import com.siyueli.platform.activity.service.constant.RefundOrderConstant;
import com.siyueli.platform.activity.service.constant.WeixinUrl;
import com.siyueli.platform.activity.service.service.payment.MiniProgramPayService;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityOrderServiceContract;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityRefundOrderServiceContract;
import com.siyueli.platform.activity.service.util.*;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class MiniProgramPayServiceImpl implements MiniProgramPayService {

    private final static Logger LOGGER = LoggerFactory.getLogger(MiniProgramPayServiceImpl.class);

    @Autowired
    private WeixinConfig weixinConfig;

    @Autowired
    private ActivityConfig activityConfig;

    @Autowired
    private SportActivityRefundOrderServiceContract sportActivityRefundOrderServiceContract;

    @Autowired
    private SportActivityOrderServiceContract sportActivityOrderServiceContract;

    @Override
    public OrderQueryResultVo orderQuery(OrderQueryVo vo, String keyParam) {
        String key = keyParam;
        if (StringUtils.isEmpty(key))
            key = weixinConfig.getKey();

        String nonceStr = RandomStringUtil.getRandomString(32);
        String signType = "MD5";
        if (StringUtils.isEmpty(vo.getAppid()))
            vo.setAppid(weixinConfig.getAppid());

        if (StringUtils.isEmpty(vo.getMch_id()))
            vo.setMch_id(weixinConfig.getMch_id());
        if (StringUtils.isEmpty(vo.getNonce_str()))
            vo.setNonce_str(nonceStr);

        if (StringUtils.isEmpty(vo.getSign_type()))
            vo.setSign_type(signType);

        Map map = null;
        try {
            map = ConvertUtil.objectToMap(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map sortedMap = MapSortUtil.sortMapByKey(map);
        String sign = ConvertUtil.getSignatureParams(sortedMap);
        LOGGER.info("sign: " + sign);
        sign = sign + "&key=" + key;
        sign = MD5Maker.getMD5(sign);
        vo.setSign(sign);

        XStream xstream = XStreamUtil.getXStream(OrderQueryVo.class);
        String xml = xstream.toXML(vo);
        String content = HttpUtils.httpsPostRequest(WeixinUrl.ORDER_QUERY_URL, xml);
        OrderQueryResultVo orderQueryResult = getOrderQueryResult(content);
        return orderQueryResult;
    }

    @Override
    public RefundResultVo refund(String orderNo) {
        EntityWrapper<SportActivityOrder> entityWrapper = new EntityWrapper<SportActivityOrder>();
        entityWrapper.eq("order_no", orderNo);

        SportActivityOrder sportActivityOrder = sportActivityOrderServiceContract.selectOne(entityWrapper);
        if (sportActivityOrder == null) {
            return null;
        }

        Date now = new Date();
        String refundOrderNo = RandomStringUtil.getCurrentAndRandom("RA");

        SportActivityRefundOrder sportActivityRefundOrder = new SportActivityRefundOrder();
        sportActivityRefundOrder.setCreateAt(now);
        sportActivityRefundOrder.setIsDeleted(0);
        sportActivityRefundOrder.setOrderId(sportActivityOrder.getId());
        sportActivityRefundOrder.setRefundAmount(sportActivityOrder.getPaidAmount());
        sportActivityRefundOrder.setRefundOrderNo(refundOrderNo);
        sportActivityRefundOrder.setSignupId(sportActivityOrder.getSignupId());
        sportActivityRefundOrder.setStatus(RefundOrderConstant.REFUND_ORDER_STATUS_APPLY);
        sportActivityRefundOrder.setUpdateAt(now);
        sportActivityRefundOrderServiceContract.insertAllColumn(sportActivityRefundOrder);

        sportActivityOrder.setStatus(OrderConstant.ORDER_STATUS_READY_REFUND);
        sportActivityOrder.setUpdateAt(now);
        sportActivityOrderServiceContract.updateAllColumnById(sportActivityOrder);


        String nonceStr = RandomStringUtil.getRandomString(32);
        String signType = "MD5";
        String key = weixinConfig.getKey();
        String notifyUrl = activityConfig.getApi_url() + weixinConfig.getRefund_notify_url();
        int refundFee = CurrencyUtil.yuanToFen(sportActivityOrder.getPaidAmount()).intValue();
        RefundRequestVo refundRequestVo = new RefundRequestVo();
        refundRequestVo.setAppid(weixinConfig.getAppid());
        refundRequestVo.setMch_id(weixinConfig.getMch_id());
        refundRequestVo.setNonce_str(nonceStr);
        refundRequestVo.setNotify_url(notifyUrl);
        refundRequestVo.setOut_refund_no(refundOrderNo);
        refundRequestVo.setOut_trade_no(orderNo);
        //refundRequestVo.setRefund_account();
        refundRequestVo.setRefund_desc("");
        refundRequestVo.setRefund_fee(refundFee);
        refundRequestVo.setTotal_fee(refundFee);
        refundRequestVo.setRefund_fee_type("CNY");
        refundRequestVo.setSign_type(signType);

        Map map = null;
        try {
            map = ConvertUtil.objectToMap(refundRequestVo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map sortedMap = MapSortUtil.sortMapByKey(map);
        String sign = ConvertUtil.getSignatureParams(sortedMap);
        LOGGER.info("sign: " + sign);
        sign = sign + "&key=" + key;
        sign = MD5Maker.getMD5(sign);

        refundRequestVo.setSign(sign);

        XStream xstream = XStreamUtil.getXStream(RefundRequestVo.class);
        String xml = xstream.toXML(refundRequestVo);

        String content = HttpUtils.httpsPostRequest(WeixinUrl.PAY_REFUND_URL, xml);
        RefundResultVo refundResult = getRefundResult(content);
        return refundResult;
    }

    @Override
    public RefundQueryResultVo refundQuery(String refundOrderNo) {
        String nonceStr = RandomStringUtil.getRandomString(32);
        String signType = "MD5";
        String key = weixinConfig.getKey();

        RefundQueryRequestVo refundQueryRequestVo = new RefundQueryRequestVo();
        refundQueryRequestVo.setAppid(weixinConfig.getAppid());
        refundQueryRequestVo.setMch_id(weixinConfig.getMch_id());
        refundQueryRequestVo.setNonce_str(nonceStr);
        refundQueryRequestVo.setSign_type(signType);
        refundQueryRequestVo.setOut_refund_no(refundOrderNo);

        Map map = null;
        try {
            map = ConvertUtil.objectToMap(refundQueryRequestVo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map sortedMap = MapSortUtil.sortMapByKey(map);
        String sign = ConvertUtil.getSignatureParams(sortedMap);
        LOGGER.info("sign: " + sign);
        sign = sign + "&key=" + key;
        sign = MD5Maker.getMD5(sign);

        refundQueryRequestVo.setSign(sign);

        XStream xstream = XStreamUtil.getXStream(RefundQueryResultVo.class);
        String xml = xstream.toXML(refundQueryRequestVo);

        String content = HttpUtils.httpsPostRequest(WeixinUrl.PAY_REFUND_QUERY_URL, xml);
        RefundQueryResultVo refundQueryResult = getRefundQueryResult(content);
        return refundQueryResult;
    }

    private RefundQueryResultVo getRefundQueryResult(String content) {
        XStream xstream = XStreamUtil.getXStream(RefundQueryResultVo.class);
        RefundQueryResultVo result = (RefundQueryResultVo)xstream.fromXML(content);
        return result;
    }

    private RefundResultVo getRefundResult(String content) {
        XStream xstream = XStreamUtil.getXStream(RefundResultVo.class);
        RefundResultVo result = (RefundResultVo)xstream.fromXML(content);
        return result;
    }

    @Override
    public OrderQueryResultVo orderQuery(OrderQueryVo oq) {
        return orderQuery(oq, null);
    }

    @Override
    public OrderQueryResultVo orderQuery(String out_trade_no) {
        OrderQueryVo oq = new OrderQueryVo();
        oq.setOut_trade_no(out_trade_no);
        return orderQuery(oq);
    }

    private OrderQueryResultVo getOrderQueryResult(String content) {
        XStream xstream = XStreamUtil.getXStream(OrderQueryResultVo.class);
        OrderQueryResultVo result = (OrderQueryResultVo)xstream.fromXML(content);
        return result;
    }
}
