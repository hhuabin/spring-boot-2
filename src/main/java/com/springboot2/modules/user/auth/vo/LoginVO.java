package com.springboot2.modules.user.auth.vo;

import com.springboot2.modules.user.info.vo.UserInfoVO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hhuabin
 * @description
 * @date 2026-11-02 14:47
 */
@Getter
@Setter
public class LoginVO {
    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 当前登录用户信息
     */
    private UserInfoVO userInfo;
}
