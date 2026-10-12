package com.springboot2.modules.user.vo;

import com.springboot2.modules.user.entity.UserInfo;

/**
 * @author hhuabin
 * @description
 * @date 2026-10-12 15:34
 */
public class UserNameVO {

    private String userName;

    public static UserNameVO from(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }

        UserNameVO vo = new UserNameVO();
        vo.setUserName(userInfo.getUserName());
        return vo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
