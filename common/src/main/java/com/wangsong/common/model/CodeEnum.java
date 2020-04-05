package com.wangsong.common.model;

public enum CodeEnum {
    SUCCESS("success"), UNAUTH("unauth"),

    INDEX("index"), LOGIN_EXCEPTION("login_exception"), NO_NULL("no_null");

    private String code;

    private CodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
