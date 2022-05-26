package com.nhnacademy.springjpa.domain;

import com.nhnacademy.springjpa.entity.Comment;
import com.nhnacademy.springjpa.entity.User;
import java.util.Date;
import java.util.List;

public interface PostDto {
    Integer getPostNo();
    User getUser();
    String getPostTitle();
    String getPostContent();
    Date getPostWriteDateTime();
    String getFileName();
    byte[] getFileData();
    List<Comment> getComments();


    interface UserDto {
        String getUserId();
    }

    interface CommentDto {
        Integer getCommentNo();
        String getCommentContent();
    }
}
