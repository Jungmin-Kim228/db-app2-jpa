package com.nhnacademy.springjpa.domain;

public interface CommentDto {
    Integer getCommentNo();
    UserDto getUser();
    String getCommentContent();

    interface UserDto {
        String getUserId();
    }
}
