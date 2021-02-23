package com.example.demo.comLangDemo;

public enum DemoCodeEnum {

    OK (200,"success"),
    FAIL (404,"failed");
    private Integer code;
    private String desc;

    DemoCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
