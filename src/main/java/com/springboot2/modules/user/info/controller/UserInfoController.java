package com.springboot2.modules.user.info.controller;

import com.springboot2.common.enums.ResultCode;
import com.springboot2.common.response.BaseResponse;
import com.springboot2.modules.user.info.entity.UserInfo;
import com.springboot2.modules.user.info.dto.UserInfoDTO;
import com.springboot2.modules.user.info.service.UserInfoService;
import com.springboot2.modules.user.info.vo.UserInfoVO;
import com.springboot2.modules.user.info.vo.UserNameVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author hhuabin
 * @date 2026-10-10 11:05
 */
@Slf4j
@CrossOrigin(origins = "*")       // 临时使用，上线需要在 nginx 配跨域
@RestController
@RequestMapping("/user/info")
public class UserInfoController {

    @Resource
    private UserInfoService  userInfoService;

    @PostMapping("/getUserInfoById")
    public BaseResponse<UserInfoVO> getUserInfoById(@RequestBody UserInfoDTO request) {
        BaseResponse<UserInfoVO> response = new BaseResponse<>();

        if (request == null || request.getUserId() == null) {
            response.error(ResultCode.PARAM_ERROR);
            return response;
        }

        UserInfo userInfo = userInfoService.getById(request.getUserId());
        if (userInfo == null) {
            response.error(ResultCode.USER_NOT_FOUND);
            return response;
        }

        response.success(UserInfoVO.from(userInfo));
        return response;
    }

    @GetMapping("/getUserNameById")
    public BaseResponse<UserNameVO> getUserNameById(@RequestParam("userId") Long userId) {
        BaseResponse<UserNameVO> response = new BaseResponse<>();

        if (userId == null) {
            response.error(ResultCode.PARAM_ERROR);
            return response;
        }

        UserInfo userInfo = userInfoService.getById(userId);
        if (userInfo == null) {
            response.error(ResultCode.USER_NOT_FOUND);
            return response;
        }

        response.success(UserNameVO.from(userInfo));
        return response;
    }
}
