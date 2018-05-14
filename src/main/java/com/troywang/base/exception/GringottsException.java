package com.troywang.base.exception;

import org.apache.commons.lang3.StringUtils;

import com.troywang.base.enums.GringottsErrorCodeEnum;

/**
 * common exception
 * Created by troywang on 2018/5/14.
 */
public class GringottsException extends RuntimeException {

    /**
     * exception定义
     */
    protected GringottsErrorCodeEnum error;

    private String errorCode;

    private String errorMsg;

    /**
     * 是否指定了错误枚举中占位符的值
     */
    private boolean isPlaceholder = false;

    public GringottsException() {
        super();
    }

    public GringottsException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public GringottsException(GringottsErrorCodeEnum baseErrorCodeEnum) {
        super(baseErrorCodeEnum.getMessage());
        this.error = baseErrorCodeEnum;
    }

    /**
     * 有占位符%s的情况，根据占位添加
     *
     * @param errorCodeEnum
     * @param placeholder
     */
    public GringottsException(GringottsErrorCodeEnum errorCodeEnum, String placeholder) {
        super(String.format(errorCodeEnum.getMessage(), placeholder));
        if (StringUtils.isNotEmpty(placeholder) && errorCodeEnum.getMessage().contains("%s")) {
            isPlaceholder = true;
            this.errorMsg = String.format(errorCodeEnum.getMessage(), placeholder);
        }
        this.error = errorCodeEnum;
    }

    /**
     * 多个占位符的情况
     *
     * @param errorCodeEnum
     * @param placeholder
     */
    public GringottsException(GringottsErrorCodeEnum errorCodeEnum, String... placeholder) {
        super(String.format(errorCodeEnum.getMessage(), placeholder));
        if (placeholder != null && errorCodeEnum.getMessage().contains("%s")) {
            isPlaceholder = true;
            this.errorMsg = String.format(errorCodeEnum.getMessage(), placeholder);
        }
        this.error = errorCodeEnum;
    }

    public GringottsErrorCodeEnum getError() {
        return error;
    }

    public void setError(GringottsErrorCodeEnum error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        if (isPlaceholder) {
            return errorMsg;
        }
        if (error != null) {
            return error.getMessage();
        }
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
