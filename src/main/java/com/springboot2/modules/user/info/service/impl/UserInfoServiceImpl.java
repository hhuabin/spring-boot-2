package com.springboot2.modules.user.info.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot2.modules.user.info.entity.UserInfo;
import com.springboot2.modules.user.info.mapper.UserInfoMapper;
import com.springboot2.modules.user.info.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author hhuabin
 * @date 2026-10-10 11:09
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public UserInfo getByUserName(String userName) {
        return lambdaQuery()
                .eq(UserInfo::getUserName, userName)
                .one();
    }
}
