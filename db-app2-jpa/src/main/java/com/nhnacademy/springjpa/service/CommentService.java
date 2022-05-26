package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.comment.CommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<CommentDto> getCommentsByPostNo(Integer postNo, Pageable pageable);
}
