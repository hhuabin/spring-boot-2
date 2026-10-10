package com.springboot2.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot2.modules.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hhuabin
 * @date 2026-10-10 11:06
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
