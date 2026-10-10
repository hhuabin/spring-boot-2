package com.springboot2.common.response;

import com.springboot2.common.enums.ResultCode;

/**
 * @description 公共返回参数对象
 * @author hhuabin
 * @date 2026-10-10 11:42
 * @param <T> 业务数据类型
 */
public class BaseResponse<T> {

    // 业务响应码
    private int code;

    // 响应消息
    private String message = "";

    // 业务数据
    private T data;

    // 无参构造
    public BaseResponse() {
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(ResultCode resultCode) {
        this(resultCode, null);
    }

    public BaseResponse(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    /** 创建成功响应，适合在控制器中直接返回。 */
    public static <T> BaseResponse<T> ok() {
        return new BaseResponse<>(ResultCode.SUCCESS);
    }

    /** 创建带业务数据的成功响应。 */
    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(ResultCode.SUCCESS, data);
    }

    /** 创建失败响应。 */
    public static <T> BaseResponse<T> fail(String message) {
        return new BaseResponse<>(ResultCode.ERROR.getCode(),
                message == null ? ResultCode.ERROR.getMessage() : message);
    }

    /** 使用业务状态码创建失败响应。 */
    public static <T> BaseResponse<T> fail(ResultCode resultCode) {
        return new BaseResponse<>(resultCode);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /** 将当前响应设置为成功状态。 */
    public void success(T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
        this.data = data;
    }

    /** 将当前响应设置为无数据的成功状态。 */
    public void success() {
        this.success(null);
    }

    /** 将当前响应设置为失败状态。 */
    public void error(String message) {
        this.code = ResultCode.ERROR.getCode();
        this.message = message == null ? ResultCode.ERROR.getMessage() : message;
        this.data = null;
    }

    /** 将当前响应设置为指定业务错误。 */
    public void error(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = null;
    }
}
