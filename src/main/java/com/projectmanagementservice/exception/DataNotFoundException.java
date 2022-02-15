package com.projectmanagementservice.exception;


public class DataNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2856472444663512791L;

    public DataNotFoundException(String message) {
        super(message);
    }

}
