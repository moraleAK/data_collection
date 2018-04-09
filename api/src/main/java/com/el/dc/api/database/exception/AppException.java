package com.el.dc.api.database.exception;

/**
 * User: Rolandz
 */
public class AppException extends RuntimeException {

    private String errCode;
    private String errMessage;

    public AppException(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public AppException(String message, String errCode, String errMessage) {
        super(message);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public AppException(String message, Throwable cause, String errCode, String errMessage) {
        super(message, cause);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public AppException(Throwable cause, String errCode, String errMessage) {
        super(cause);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errCode, String errMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
