package com.nhnacademy.springjpa.domain.comment;

import lombok.Data;

@Data
public class CommentRequest {
    Integer postNo;
    Integer userNo;
    String commentContent;
}
