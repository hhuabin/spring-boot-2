package com.springboot2.modules.user.service.info;

import com.baomidou.mybatisplus.spring.service.IService;
import com.springboot2.modules.user.entity.info.UserInfo;

/**
 * @author hhuabin
 * @date 2026-10-10 11:08
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 按用户名查询用户，供 auth 等其他子域复用。
     *
     * @param userName 用户名
     * @return 用户实体，不存在时返回 null
     */
    UserInfo getUserInfoByUserName(String userName);
}
