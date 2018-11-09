package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivitySponsor;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivitySponsorMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivitySponsorServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体育活动_主办方 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivitySponsorService extends ServiceImpl<SportActivitySponsorMapper, SportActivitySponsor> implements SportActivitySponsorServiceContract {

}
