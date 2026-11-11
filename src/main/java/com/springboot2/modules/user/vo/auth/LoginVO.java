package com.springboot2.modules.user.vo.auth;

import com.springboot2.modules.user.vo.info.UserInfoVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hhuabin
 * @description
 * @date 2026-11-02 14:47
 */
@Getter
@Setter
@ToString
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
