package com.siyueli.platform.activity.service.service.sportinfomation.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportinformation.SportInfomationCategory;
import com.siyueli.platform.activity.service.mapper.sportinfomation.SportInfomationCategoryMapper;
import com.siyueli.platform.activity.service.service.sportinfomation.SportInfomationCategoryServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资讯分类 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportInfomationCategoryService extends ServiceImpl<SportInfomationCategoryMapper, SportInfomationCategory> implements SportInfomationCategoryServiceContract {

}
