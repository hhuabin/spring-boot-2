package com.springboot2.modules.user.service;

import com.springboot2.modules.user.entity.UserInfo;
import com.springboot2.modules.user.mapper.UserInfoMapper;
import com.springboot2.modules.user.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class UserInfoServiceSpringBootTest {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void shouldQueryUserWithId10ByMapper() {
        assertNotNull(userInfoService);
        assertNotNull(userInfoMapper);

        UserInfo user = userInfoMapper.selectById(10L);

        assertNotNull(user, "userId=10 的用户不存在");

        UserInfoVO userInfoVO = UserInfoVO.from(user);

        log.info("UserInfo 数据库实体：userId={}, userName={}, realName={}, phone={}, "
                        + "birthday={}, gender={}, email={}, address={}, avatar={}, "
                        + "signature={}, status={}, lastLoginTime={}, lastLoginIp={}, "
                        + "createTime={}, updateTime={}, isDeleted={}",
                user.getUserId(), user.getUserName(), user.getRealName(), user.getPhone(),
                user.getBirthday(), user.getGender(), user.getEmail(), user.getAddress(),
                user.getAvatar(), user.getSignature(), user.getStatus(),
                user.getLastLoginTime(), user.getLastLoginIp(), user.getCreateTime(),
                user.getUpdateTime(), user.getIsDeleted());

        log.info("UserInfoVO 返回对象：userId={}, userName={}, realName={}, phone={}, "
                        + "birthday={}, gender={}, email={}, address={}, avatar={}, "
                        + "signature={}, status={}, lastLoginTime={}",
                userInfoVO.getUserId(), userInfoVO.getUserName(), userInfoVO.getRealName(),
                userInfoVO.getPhone(), userInfoVO.getBirthday(), userInfoVO.getGender(),
                userInfoVO.getEmail(), userInfoVO.getAddress(), userInfoVO.getAvatar(),
                userInfoVO.getSignature(), userInfoVO.getStatus(),
                userInfoVO.getLastLoginTime());
    }
}
