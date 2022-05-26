package com.nhnacademy.springjpa.domain;

import com.nhnacademy.springjpa.entity.User;
import java.util.Date;

public interface PostDto {
    Integer getPostNo();
    User getUser();
    String getPostTitle();
    String getPostContent();
    Date getPostWriteDateTime();
    String getFileName();
    byte[] getFileData();

    interface UserDto {
        String getUserId();
    }

}
