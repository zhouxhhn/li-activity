package com.siyueli.platform.activity.service.service.sportmemberfavorites.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.sportmemberfavorites.SportMemberFavorites;
import com.siyueli.platform.activity.service.mapper.sportmemberfavorites.SportMemberFavoritesMapper;
import com.siyueli.platform.activity.service.service.sportmemberfavorites.SportMemberFavoritesServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 体育活动_收藏 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportMemberFavoritesService extends ServiceImpl<SportMemberFavoritesMapper, SportMemberFavorites> implements SportMemberFavoritesServiceContract {

}
