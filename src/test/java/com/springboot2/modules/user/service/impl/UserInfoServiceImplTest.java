package com.springboot2.modules.user.service.impl;

import com.springboot2.modules.user.entity.UserInfo;
import com.springboot2.modules.user.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserInfoServiceImplTest {

    @Mock
    private UserInfoMapper userInfoMapper;

    @InjectMocks
    private UserInfoServiceImpl userInfoService;

    @Test
    void getByIdShouldReturnUserWhenUserExists() {
        UserInfo expected = new UserInfo();
        expected.setUserId(1L);
        expected.setUserName("alice");
        when(userInfoMapper.selectById(1L)).thenReturn(expected);

        UserInfo actual = userInfoService.getById(1L);

        assertEquals(expected, actual);
        assertEquals("alice", actual.getUserName());
        verify(userInfoMapper).selectById(1L);
    }

    @Test
    void getByIdShouldReturnNullWhenUserDoesNotExist() {
        when(userInfoMapper.selectById(99L)).thenReturn(null);

        UserInfo actual = userInfoService.getById(99L);

        assertNull(actual);
        verify(userInfoMapper).selectById(99L);
    }
}
