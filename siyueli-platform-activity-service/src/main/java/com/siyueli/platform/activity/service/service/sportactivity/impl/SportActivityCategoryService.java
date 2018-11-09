package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivityCategory;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivityCategoryMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityCategoryServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动分类 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivityCategoryService extends ServiceImpl<SportActivityCategoryMapper, SportActivityCategory> implements SportActivityCategoryServiceContract {

}
