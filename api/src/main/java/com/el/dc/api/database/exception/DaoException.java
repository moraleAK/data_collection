package com.el.dc.api.database.exception;

public class DaoException extends AppException {
    public DaoException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public DaoException(String message, String errCode, String errMessage) {
        super(message, errCode, errMessage);
    }

    public DaoException(String message, Throwable cause, String errCode, String errMessage) {
        super(message, cause, errCode, errMessage);
    }

    public DaoException(Throwable cause, String errCode, String errMessage) {
        super(cause, errCode, errMessage);
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errCode, String errMessage) {
        super(message, cause, enableSuppression, writableStackTrace, errCode, errMessage);
    }
}
