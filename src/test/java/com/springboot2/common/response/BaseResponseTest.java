package com.springboot2.common.response;

import com.springboot2.common.enums.ResultCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BaseResponseTest {

    @Test
    void okShouldCreateSuccessfulResponseWithData() {
        BaseResponse<String> response = BaseResponse.ok("hello");

        assertEquals(ResultCode.SUCCESS.getCode(), response.getCode());
        assertEquals(ResultCode.SUCCESS.getMessage(), response.getMessage());
        assertEquals("hello", response.getData());
    }

    @Test
    void errorShouldClearDataAndUseDefaultMessageWhenMessageIsNull() {
        BaseResponse<String> response = BaseResponse.ok("old-data");

        response.error((String) null);

        assertEquals(ResultCode.ERROR.getCode(), response.getCode());
        assertEquals(ResultCode.ERROR.getMessage(), response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void settersGeneratedByLombokShouldUpdateResponseFields() {
        BaseResponse<String> response = new BaseResponse<>();

        response.setCode(200);
        response.setMessage("custom message");
        response.setData("data");

        assertEquals(200, response.getCode());
        assertEquals("custom message", response.getMessage());
        assertEquals("data", response.getData());
    }
}
