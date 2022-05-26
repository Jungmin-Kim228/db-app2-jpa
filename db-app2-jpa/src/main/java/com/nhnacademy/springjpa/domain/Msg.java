package com.nhnacademy.springjpa.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Msg<T> {
    private static final String SUCCESS = "OK";
    private static final String FAIL = "FAIL";
    private String status;
    private String message;
    private T data;

    private Msg(){}

    @JsonCreator
    private Msg(String status, String message, T t) {
        this.status = status;
        this.message = message;
        this.data = t;
    }

    public static Msg success(Object object) {
        return new Msg(SUCCESS, "success", object);
    }
}
