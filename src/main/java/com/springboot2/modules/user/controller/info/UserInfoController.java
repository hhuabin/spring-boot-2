package com.springboot2.modules.user.controller.info;

import com.springboot2.common.enums.ResultCode;
import com.springboot2.common.response.BaseResponse;
import com.springboot2.modules.user.entity.info.UserInfo;
import com.springboot2.modules.user.dto.info.UserInfoDTO;
import com.springboot2.modules.user.service.info.UserInfoService;
import com.springboot2.modules.user.vo.info.UserInfoVO;
import com.springboot2.modules.user.vo.info.UserNameVO;
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

    /**
     * 根据用户 id 获取用户信息
     * @param request 用户信息查询请求参数
     * @return 用户信息
     */
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

    /**
     * 根据用户 id 获取用户名字
     * @param userId 用户 id
     * @return 用户名
     */
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
