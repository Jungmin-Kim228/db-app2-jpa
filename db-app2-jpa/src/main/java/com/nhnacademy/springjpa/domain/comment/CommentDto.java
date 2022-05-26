package com.nhnacademy.springjpa.domain.comment;

public interface CommentDto {
    Integer getCommentNo();
    UserDto getUser();
    String getCommentContent();

    interface UserDto {
        String getUserId();
    }
}
