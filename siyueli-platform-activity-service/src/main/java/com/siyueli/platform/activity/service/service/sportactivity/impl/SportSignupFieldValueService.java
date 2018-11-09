package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportSignupFieldValue;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportSignupFieldValueMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportSignupFieldValueServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动报名字段值表 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportSignupFieldValueService extends ServiceImpl<SportSignupFieldValueMapper, SportSignupFieldValue> implements SportSignupFieldValueServiceContract {

}
