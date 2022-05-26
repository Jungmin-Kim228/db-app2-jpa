package com.nhnacademy.springjpa.domain.post;

import lombok.Data;

@Data
public class PostRegisterRequest {
    Integer userNo;
    String postTitle;
    String postContent;
    String fileName;
    byte[] fileData;

}
