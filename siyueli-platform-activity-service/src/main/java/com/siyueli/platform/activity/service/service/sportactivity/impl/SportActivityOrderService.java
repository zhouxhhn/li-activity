package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityOrder;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivityOrderMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityOrderServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动报名订单 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivityOrderService extends ServiceImpl<SportActivityOrderMapper, SportActivityOrder> implements SportActivityOrderServiceContract {

}
