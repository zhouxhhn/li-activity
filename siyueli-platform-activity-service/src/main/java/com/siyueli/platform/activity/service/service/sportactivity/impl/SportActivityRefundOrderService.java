package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityRefundOrder;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivityRefundOrderMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityRefundOrderServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动报名退款单 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivityRefundOrderService extends ServiceImpl<SportActivityRefundOrderMapper, SportActivityRefundOrder> implements SportActivityRefundOrderServiceContract {

}
