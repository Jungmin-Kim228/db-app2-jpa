package com.nhnacademy.springjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public interface PostDto {
    Integer getPostNo();
    UserDto getUser();
    String getPostTitle();
    String getPostContent();
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    LocalDateTime getPostWriteDateTime();
    String getFileName();
    byte[] getFileData();

    interface UserDto {
        String getUserId();
    }

}
