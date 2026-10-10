package com.springboot2.modules.user.vo;

import com.springboot2.modules.user.entity.UserInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @description 用户信息返回参数
 * @author hhuabin
 * @date 2026-10-10 11:14
 */
public class UserInfoVO {

    private Long userId;
    private String userName;
    private String realName;
    private String phone;
    private LocalDate birthday;
    private String gender;
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

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getRealName() { return realName; }
    public void setRealName(String realName) { this.realName = realName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getBirthday() { return birthday; }
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getSignature() { return signature; }
    public void setSignature(String signature) { this.signature = signature; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public LocalDateTime getLastLoginTime() { return lastLoginTime; }
    public void setLastLoginTime(LocalDateTime lastLoginTime) { this.lastLoginTime = lastLoginTime; }
}
