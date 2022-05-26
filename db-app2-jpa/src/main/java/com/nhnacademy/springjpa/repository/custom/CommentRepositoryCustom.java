package com.nhnacademy.springjpa.repository.custom;

import com.nhnacademy.springjpa.domain.comment.CommentDto;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommentRepositoryCustom {
    List<CommentDto> getCommentsByPost_PostNo(Integer postNo);
}
