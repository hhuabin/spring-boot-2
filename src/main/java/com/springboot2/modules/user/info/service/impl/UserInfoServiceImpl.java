package com.springboot2.modules.user.info.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.springboot2.modules.user.info.entity.UserInfo;
import com.springboot2.modules.user.info.mapper.UserInfoMapper;
import com.springboot2.modules.user.info.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hhuabin
 * @date 2026-10-10 11:09
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoByUserName(String userName) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getUserName,userName);

        return userInfoMapper.selectOne(wrapper);
    }
}
