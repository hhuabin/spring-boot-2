package com.springboot2.modules.user.vo.info;

import com.springboot2.modules.user.entity.info.UserInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hhuabin
 * @description
 * @date 2026-10-12 15:34
 */
@Getter
@Setter
@ToString
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
