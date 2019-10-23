package com.bytheone.exception;

/**
 * @author ArtLinty
 * @date 2017/12/15.
 * @email liu.tingli@qq.com
 */
public class MyException extends RuntimeException {

    private String message;

    public MyException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
