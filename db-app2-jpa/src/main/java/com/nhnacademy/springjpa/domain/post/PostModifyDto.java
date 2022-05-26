package com.nhnacademy.springjpa.domain.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public interface PostModifyDto {
    Integer getPostNo();
    UserDto getUser();
    String getPostTitle();
    String getPostContent();
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    LocalDateTime getPostModifyDateTime();
    String getFileName();
    byte[] getFileData();

    interface UserDto {
        String getUserId();
    }
}
