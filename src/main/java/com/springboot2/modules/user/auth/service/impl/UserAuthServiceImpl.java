package com.springboot2.modules.user.auth.service.impl;

import com.springboot2.common.enums.ResultCode;
import com.springboot2.modules.user.auth.dto.UserLoginDTO;
import com.springboot2.modules.user.auth.service.UserAuthService;
import com.springboot2.modules.user.auth.vo.LoginVO;
import com.springboot2.modules.user.info.entity.UserInfo;
import com.springboot2.modules.user.info.service.UserInfoService;
import com.springboot2.modules.user.info.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @description 用户认证服务实现。跨子域取数只走 UserInfoService 接口，
 * 不直接触碰 info 子域的 mapper / entity 之外的内部类。
 * @author hhuabin
 * @date 2026-11-02 16:21
 */
@Slf4j
@Service
public class UserAuthServiceImpl implements UserAuthService {

    /** TODO 接入 JWT 后替换为真实 token 生成 */
    private static final String TEMPORARY_ACCESS_TOKEN = "temporary-access-token";

    @Resource
    private UserInfoService userInfoService;

    @Override
    public LoginVO login(UserLoginDTO request) {
        UserInfo userInfo = userInfoService.getUserInfoByUserName(request.getUserName());

        // 用户不存在和密码不正确使用相同提示，避免泄露用户名是否存在。
        if (userInfo == null || !Objects.equals(userInfo.getPassword(), request.getPassword())) {
            return null;
        }

        LoginVO loginVO = new LoginVO();
        loginVO.setAccessToken(TEMPORARY_ACCESS_TOKEN);
        loginVO.setUserInfo(UserInfoVO.from(userInfo));
        return loginVO;
    }
}
