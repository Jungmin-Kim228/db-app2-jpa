package com.nhnacademy.springjpa.repository.custom;

import com.nhnacademy.springjpa.domain.comment.CommentDto;
import com.nhnacademy.springjpa.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CommentRepositoryImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {
    public CommentRepositoryImpl() {
        super(Comment.class);
    }

    @Override
    public List<CommentDto> getCommentsByPost_PostNo(Integer postNo) {
        QComment comment = QComment.comment;


        return null;
    }
}
