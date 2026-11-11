package com.springboot2.modules.user.controller.auth;

import com.springboot2.common.enums.ResultCode;
import com.springboot2.common.response.BaseResponse;
import com.springboot2.modules.user.dto.auth.UserLoginDTO;
import com.springboot2.modules.user.service.auth.UserAuthService;
import com.springboot2.modules.user.vo.auth.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author hhuabin
 * @description 用户认证接口。只做参数校验和调用 Service，
 * 业务逻辑在 UserAuthServiceImpl 中。
 * @date 2026-11-02 16:02
 */
@Slf4j
@CrossOrigin(origins = "*")       // 临时使用，上线需要在 nginx 配跨域
@RestController
@RequestMapping("/user/auth")
public class UserAuthController {

    @Resource
    private UserAuthService userAuthService;

    /**
     * 用户登录。
     *
     * @param request 用户名和密码
     * @return 登录成功后的脱敏用户信息
     */
    @PostMapping("/login")
    public BaseResponse<LoginVO> login(@RequestBody UserLoginDTO request) {
        log.info("进入 /user/auth/login 用户登录接口");
        if (request == null
                || !StringUtils.hasText(request.getUserName())
                || !StringUtils.hasText(request.getPassword())) {
            return BaseResponse.fail(ResultCode.PARAM_ERROR);
        }

        LoginVO loginVO = userAuthService.login(request);
        if (loginVO == null) {
            return BaseResponse.fail(ResultCode.PASSWORD_ERROR);
        }
        return BaseResponse.ok(loginVO);
    }
}
