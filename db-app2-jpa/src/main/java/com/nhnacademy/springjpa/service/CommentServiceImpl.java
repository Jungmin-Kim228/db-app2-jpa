package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.comment.CommentDto;
import com.nhnacademy.springjpa.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Page<CommentDto> getCommentsByPostNo(Integer postNo, Pageable pageable) {
        return commentRepository.getCommentDtosAllByPost_PostNo(postNo, pageable);
    }
}
