package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.comment.CommentDto;
import com.nhnacademy.springjpa.entity.Comment;
import com.nhnacademy.springjpa.repository.custom.CommentRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer>, CommentRepositoryCustom {
    Page<CommentDto> getCommentDtosAllByPost_PostNo(Integer postNo, Pageable pageable);

    CommentDto getCommentDtoByCommentNo(Integer commentNo);
}
