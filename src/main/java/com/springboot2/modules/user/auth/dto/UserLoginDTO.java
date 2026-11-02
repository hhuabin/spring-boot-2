package com.springboot2.modules.user.auth.dto;

import com.springboot2.common.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户登录请求参数。
 */
@Getter
@Setter
public class UserLoginDTO extends BaseRequest {

    private String userName;

    private String password;
}
