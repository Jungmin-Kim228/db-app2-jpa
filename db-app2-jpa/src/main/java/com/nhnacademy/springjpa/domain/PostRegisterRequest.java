package com.nhnacademy.springjpa.domain;

import lombok.Data;

@Data
public class PostRegisterRequest {
    Integer userNo;
    String postTitle;
    String postContent;
    String fileName;
    byte[] fileData;

}
