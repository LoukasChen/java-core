package com.csp.designPattern.creation.singleton.di;

/**
 * @author csp
 * @date 2022/9/24
 */
public class BeanCreationFailureException extends RuntimeException {

    public BeanCreationFailureException() {
        super();
    }

    public BeanCreationFailureException(String message) {
        super(message);
    }

    public BeanCreationFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
