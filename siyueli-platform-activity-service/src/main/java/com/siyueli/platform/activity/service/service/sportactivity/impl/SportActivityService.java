package com.siyueli.platform.activity.service.service.sportactivity.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.common.PageResponse;
import com.siyueli.platform.activity.common.entity.sportactivity.SportActivity;
import com.siyueli.platform.activity.common.request.sportactivity.SportActivitySearchRequest;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityVo;
import com.siyueli.platform.activity.service.mapper.sportactivity.SportActivityMapper;
import com.siyueli.platform.activity.service.service.sportactivity.SportActivityServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 体育活动 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class SportActivityService extends ServiceImpl<SportActivityMapper, SportActivity> implements SportActivityServiceContract {

    @Autowired
    private SportActivityMapper sportActivityMapper;

    @Override
    public PageResponse<SportActivityVo> search(SportActivitySearchRequest requestParam) {
        Page<SportActivity> page = new Page<SportActivity>(requestParam.getPage(), requestParam.getSize());
        List<SportActivityVo> list = sportActivityMapper.search(page);

        PageResponse<SportActivityVo> pageResponse = new PageResponse<SportActivityVo>();
        pageResponse.setRecords(list);
        pageResponse.setPages(page.getPages());
        pageResponse.setTotal(page.getTotal());
        pageResponse.setCurrent(page.getCurrent());
        pageResponse.setSize(page.getSize());

        return pageResponse;
    }
}
