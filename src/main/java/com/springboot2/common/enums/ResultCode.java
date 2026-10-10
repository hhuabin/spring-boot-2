package com.springboot2.common.enums;

/**
 * @description 业务响应状态码枚举类
 * @author hhuabin
 * @date 2026-10-10 11:42
 */
public enum ResultCode {

    // ==================== 成功 ====================

    SUCCESS(0, "操作成功"),

    // ==================== 通用错误 ====================

    ERROR(-1, "系统内部错误"),

    PARAM_ERROR(400, "请求参数错误"),
    UNAUTHORIZED(401, "未登录或登录凭证无效"),
    FORBIDDEN(403, "无权访问该资源"),
    RESOURCE_NOT_FOUND(404, "请求的资源不存在"),

    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    BAD_GATEWAY(502, "网关错误"),
    SERVICE_UNAVAILABLE(503, "服务暂不可用"),

    // ==================== 业务错误 ====================

    USER_NOT_FOUND(3001, "用户不存在"),
    USERNAME_ALREADY_EXISTS(3002, "用户名已存在"),
    PASSWORD_ERROR(3003, "用户名或密码错误");

    /**
     * 业务响应码
     */
    private final int code;

    /**
     * 默认响应消息
     */
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
