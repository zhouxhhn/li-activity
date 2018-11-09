package com.siyueli.platform.activity.service.mapper.customform;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.siyueli.platform.activity.common.entity.customform.CustomForm;
import com.siyueli.platform.activity.common.response.customform.CustomFormVo;
import com.siyueli.platform.activity.common.response.sportactivity.SportActivityVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 表单 Mapper 接口
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Repository
public interface CustomFormMapper extends BaseMapper<CustomForm> {


    public List<CustomFormVo> search(Pagination page);
}
