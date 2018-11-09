package com.siyueli.platform.activity.service.mapper.sportactivity;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivity;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 体育活动 Mapper 接口
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Repository
public interface SportActivityMapper extends BaseMapper<SportActivity> {

    public List<SportActivityVo> search(Pagination page);
}
