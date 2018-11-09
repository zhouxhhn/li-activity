package com.siyueli.platform.activity.service.service.member.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siyueli.platform.activity.common.entity.member.MemberUser;
import com.siyueli.platform.activity.service.mapper.member.MemberUserMapper;
import com.siyueli.platform.activity.service.service.member.MemberUserServiceContract;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Primary
@Service
public class MemberUserService extends ServiceImpl<MemberUserMapper, MemberUser> implements MemberUserServiceContract {

}
