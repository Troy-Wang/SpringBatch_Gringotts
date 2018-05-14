package com.troywang.base.exception;

/**
 * validator exception
 * Created by troywang on 2018/5/14.
 */
public class GringottsValidatorException extends RuntimeException {

    private String errorMsg;

    public GringottsValidatorException() {
        super();
    }

    public GringottsValidatorException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
