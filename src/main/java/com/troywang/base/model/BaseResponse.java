package com.troywang.base.model;

import com.troywang.base.enums.GringottsErrorCodeEnum;

/**
 * base response
 * Created by troywang on 2018/5/15.
 */
public class BaseResponse {

    private String resultCode;

    private String resultMsg;

    public BaseResponse() {
        this.resultCode = GringottsErrorCodeEnum.SUCCESS.getCode();
        this.resultMsg = GringottsErrorCodeEnum.SUCCESS.getMessage();
    }

    public BaseResponse(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
