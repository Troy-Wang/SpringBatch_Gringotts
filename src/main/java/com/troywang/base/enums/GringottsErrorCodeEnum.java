package com.troywang.base.enums;

/**
 * error codes
 * Created by troywang on 2018/5/14.
 */
public enum GringottsErrorCodeEnum {

    SUCCESS("000000", "SUCCESS"),

    FAIL("000001", "FAIL"),

    JOB_LAUNCH_FAIL("000002", "Job Launch Failed"),

    DATABASE_OPERATION_ERROR("000003", "Database Operation Failed");

    private String code;
    private String message;

    GringottsErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

