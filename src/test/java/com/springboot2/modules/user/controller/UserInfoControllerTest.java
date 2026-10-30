package com.springboot2.modules.user.controller;

import com.springboot2.common.enums.ResultCode;
import com.springboot2.modules.user.entity.UserInfo;
import com.springboot2.modules.user.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserInfoController.class)
class UserInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserInfoService userInfoService;

    @Test
    void getUserInfoByIdShouldReturnUserInfoWhenUserExists() throws Exception {
        UserInfo userInfo = userInfo(1L, "alice");
        when(userInfoService.getById(1L)).thenReturn(userInfo);

        mockMvc.perform(post("/user/getUserInfoById")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code").value(ResultCode.SUCCESS.getCode()))
                .andExpect(jsonPath("$.message").value(ResultCode.SUCCESS.getMessage()))
                .andExpect(jsonPath("$.data.userId").value(1))
                .andExpect(jsonPath("$.data.userName").value("alice"))
                .andExpect(jsonPath("$.data.password").doesNotExist());

        verify(userInfoService).getById(eq(1L));
    }

    @Test
    void getUserInfoByIdShouldReturnParamErrorWhenUserIdIsMissing() throws Exception {
        mockMvc.perform(post("/user/getUserInfoById")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(ResultCode.PARAM_ERROR.getCode()))
                .andExpect(jsonPath("$.message").value(ResultCode.PARAM_ERROR.getMessage()))
                .andExpect(jsonPath("$.data").doesNotExist());

        verifyNoInteractions(userInfoService);
    }

    @Test
    void getUserInfoByIdShouldReturnNotFoundWhenUserDoesNotExist() throws Exception {
        when(userInfoService.getById(99L)).thenReturn(null);

        mockMvc.perform(post("/user/getUserInfoById")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":99}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(ResultCode.USER_NOT_FOUND.getCode()))
                .andExpect(jsonPath("$.message").value(ResultCode.USER_NOT_FOUND.getMessage()))
                .andExpect(jsonPath("$.data").doesNotExist());
    }

    @Test
    void getUserNameByIdShouldReturnUserNameWhenUserExists() throws Exception {
        when(userInfoService.getById(1L)).thenReturn(userInfo(1L, "alice"));

        mockMvc.perform(get("/user/getUserNameById")
                        .param("userId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(ResultCode.SUCCESS.getCode()))
                .andExpect(jsonPath("$.data.userName").value("alice"));
    }

    @Test
    void getUserNameByIdShouldReturnNotFoundWhenUserDoesNotExist() throws Exception {
        when(userInfoService.getById(99L)).thenReturn(null);

        mockMvc.perform(get("/user/getUserNameById")
                        .param("userId", "99"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(ResultCode.USER_NOT_FOUND.getCode()))
                .andExpect(jsonPath("$.message").value(ResultCode.USER_NOT_FOUND.getMessage()))
                .andExpect(jsonPath("$.data").doesNotExist());
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
