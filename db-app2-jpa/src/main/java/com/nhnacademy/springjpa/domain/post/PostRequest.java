package com.nhnacademy.springjpa.domain.post;

import lombok.Data;

@Data
public class PostRequest {
    Integer userNo;
    String postTitle;
    String postContent;
    String fileName;
    byte[] fileData;
}
