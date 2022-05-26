package com.nhnacademy.springjpa.repository.custom;

import com.nhnacademy.springjpa.domain.comment.CommentDto;
import com.nhnacademy.springjpa.entity.Comment;
import com.nhnacademy.springjpa.entity.QComment;
import com.nhnacademy.springjpa.entity.QPost;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CommentRepositoryImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {
    public CommentRepositoryImpl() {
        super(Comment.class);
    }

    @Override
    public List<CommentDto> getCommentsByPost_PostNo(Integer postNo) {
        QComment comment = QComment.comment;
        QPost post = QPost.post;

//        return from(comment)
//            .innerJoin(comment.post, post)
//            .where(post.postNo)
//            .select(comment)
//            .fetch();

        return null;
    }
}
