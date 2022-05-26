package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.comment.CommentDto;
import com.nhnacademy.springjpa.domain.comment.CommentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<CommentDto> getCommentsByPostNo(Integer postNo, Pageable pageable);

    CommentDto createComment(CommentRequest commentRequest);

    CommentDto modifyComment(Integer commentNo, CommentRequest commentRequest);

    Integer deleteComment(Integer commentNo);
}
