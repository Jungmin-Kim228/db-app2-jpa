package com.nhnacademy.springjpa.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Msg<T> {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
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

    public static Msg success(Object tt) {
        return new Msg(SUCCESS, "success", tt);
    }
}
