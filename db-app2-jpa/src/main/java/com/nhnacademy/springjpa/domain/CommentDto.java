package com.nhnacademy.springjpa.domain;

import com.nhnacademy.springjpa.entity.User;

public interface CommentDto {
    Integer getCommentNo();
    User getUser();
    String getCommentContent();

    interface UserDto {
        String getUserId();
    }
}
