package com.springboot2.modules.user.vo;

import com.springboot2.modules.user.entity.UserInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @description 用户信息返回参数
 * @author hhuabin
 * @date 2026-10-10 11:14
 */
@Getter
@Setter
public class UserInfoVO {

    private Long userId;
    private String userName;
    private String realName;
    private String phone;
    private LocalDate birthday;
    private Integer gender;
    private String email;
    private String address;
    private String avatar;
    private String signature;
    private Integer status;
    private LocalDateTime lastLoginTime;

    /**
     * @description 将数据库实体转换为返回给前端的对象。
     * 密码、删除标记、最后登录 IP 等内部字段不会返回。
     */
    public static UserInfoVO from(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }

        UserInfoVO vo = new UserInfoVO();
        vo.setUserId(userInfo.getUserId());
        vo.setUserName(userInfo.getUserName());
        vo.setRealName(userInfo.getRealName());
        vo.setPhone(userInfo.getPhone());
        vo.setBirthday(userInfo.getBirthday());
        vo.setGender(userInfo.getGender());
        vo.setEmail(userInfo.getEmail());
        vo.setAddress(userInfo.getAddress());
        vo.setAvatar(userInfo.getAvatar());
        vo.setSignature(userInfo.getSignature());
        vo.setStatus(userInfo.getStatus());
        vo.setLastLoginTime(userInfo.getLastLoginTime());
        return vo;
    }

}
