package com.springboot2.modules.user.auth.service.impl;

import com.springboot2.modules.user.dto.auth.UserLoginDTO;
import com.springboot2.modules.user.service.auth.impl.UserAuthServiceImpl;
import com.springboot2.modules.user.vo.auth.LoginVO;
import com.springboot2.modules.user.entity.info.UserInfo;
import com.springboot2.modules.user.service.info.UserInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserAuthServiceImplTest {

    @Mock
    private UserInfoService userInfoService;

    @InjectMocks
    private UserAuthServiceImpl userAuthService;

    @Test
    void loginShouldReturnTokenAndUserInfoWhenCredentialsAreCorrect() {
        when(userInfoService.getUserInfoByUserName("alice")).thenReturn(userInfo(1L, "alice"));

        LoginVO loginVO = userAuthService.login(loginDTO("alice", "secret"));

        assertEquals("temporary-access-token", loginVO.getAccessToken());
        assertNotNull(loginVO.getUserInfo());
        assertEquals(1L, loginVO.getUserInfo().getUserId());
        assertEquals("alice", loginVO.getUserInfo().getUserName());
    }

    @Test
    void loginShouldReturnNullWhenUserDoesNotExist() {
        when(userInfoService.getUserInfoByUserName("bob")).thenReturn(null);

        assertNull(userAuthService.login(loginDTO("bob", "secret")));
    }

    @Test
    void loginShouldReturnNullWhenPasswordIsIncorrect() {
        when(userInfoService.getUserInfoByUserName("alice")).thenReturn(userInfo(1L, "alice"));

        assertNull(userAuthService.login(loginDTO("alice", "wrong")));
    }

    private UserLoginDTO loginDTO(String userName, String password) {
        UserLoginDTO dto = new UserLoginDTO();
        dto.setUserName(userName);
        dto.setPassword(password);
        return dto;
    }

    private UserInfo userInfo(Long userId, String userName) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName(userName);
        userInfo.setPassword("secret");
        userInfo.setRealName("Alice");
        userInfo.setBirthday(LocalDate.of(1990, 1, 1));
        return userInfo;
    }
}
