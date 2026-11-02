package com.springboot2.modules.user.auth.service;

import com.springboot2.modules.user.auth.dto.UserLoginDTO;
import com.springboot2.modules.user.auth.vo.LoginVO;

/**
 * @description 用户认证服务：登录、token 等与凭证相关的业务。
 * @author hhuabin
 * @date 2026-11-02 16:21
 */
public interface UserAuthService {

    /**
     * 用户登录。
     *
     * @param request 用户名和密码
     * @return 登录成功后的令牌和脱敏用户信息；用户名或密码错误时返回 null
     */
    LoginVO login(UserLoginDTO request);
}
