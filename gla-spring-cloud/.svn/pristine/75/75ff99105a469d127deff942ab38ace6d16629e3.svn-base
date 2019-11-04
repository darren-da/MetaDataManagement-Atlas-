package com.limp.framework.boss.exception;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 16-2-4
 * Time: 下午11:14
 * 用户登录异常
 * To change this template use File | Settings | File Templates.
 */
public class LoginException extends RuntimeException {
    private Error error;

    public static enum Error{
        /**
         *
         */
        UN_EXISTS(-1),
        /**
         *
         */
        ACCOUNT_ERROR(2),
        /**
         *
         */
        IP_MAC_ERROR(3),
        /**
         *
         */
        STATE_ERROR(4),
        /**
         *
         */
        EXPIRED(5);

        int value;

        private Error(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public LoginException() {
    }

    public LoginException(Error error) {
        this.error = error;
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return error.toString().toLowerCase();
    }
}
