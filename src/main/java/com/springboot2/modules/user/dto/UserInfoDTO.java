package com.springboot2.modules.user.dto;

import com.springboot2.common.request.BaseRequest;

/**
 * @description 用户信息请求参数
 * @author hhuabin
 * @date 2026-10-10 11:31
 */
public class UserInfoDTO extends BaseRequest {

    /**
     * 查询用户时使用的用户 ID。
     */
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
