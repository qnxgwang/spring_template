package com.template.utils;

public enum Status {

    ArgumentNotValid(400, "ArgumentNotValid"),

    Success(200, "success"),

    UnknownError(407, "UnknownError");

    private int code;

    private String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
