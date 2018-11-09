package com.siyueli.platform.activity.service.service.sportinfomation.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportinformation.SportInformation;
import com.siyueli.platform.activity.service.mapper.sportinfomation.SportInformationMapper;
import com.siyueli.platform.activity.service.service.sportinfomation.SportInformationServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资讯 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportInformationService extends ServiceImpl<SportInformationMapper, SportInformation> implements SportInformationServiceContract {

}
