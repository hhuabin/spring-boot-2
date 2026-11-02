package com.springboot2.modules.user.info.vo;

import com.springboot2.modules.user.info.entity.UserInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hhuabin
 * @description
 * @date 2026-10-12 15:34
 */
@Getter
@Setter
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

}
