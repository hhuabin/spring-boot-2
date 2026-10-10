package com.springboot2.common.request;

/**
 * @description 公共请求参数基类
 * @author hhuabin
 * @date 2026-10-10 11:42
 */
public class BaseRequest {

    // 请求时间：格式 YYYY-MM-DD hh:mm:ss
    private String timestamp;

    public BaseRequest() {
    }

    public BaseRequest(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
