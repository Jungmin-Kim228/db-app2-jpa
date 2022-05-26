package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.comment.CommentDto;
import com.nhnacademy.springjpa.domain.comment.CommentRequest;
import com.nhnacademy.springjpa.entity.Comment;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import com.nhnacademy.springjpa.repository.CommentRepository;
import com.nhnacademy.springjpa.repository.PostRepository;
import com.nhnacademy.springjpa.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository,
                              UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<CommentDto> getCommentsByPostNo(Integer postNo, Pageable pageable) {
        return commentRepository.getCommentDtosAllByPost_PostNo(postNo, pageable);
    }

    @Transactional
    @Override
    public CommentDto createComment(CommentRequest commentRequest) {
        Post post = postRepository.getPostByPostNo(commentRequest.getPostNo());
        User user = userRepository.getUserByUserNo(commentRequest.getUserNo());
        Comment comment = Comment.addComment()
            .user(user)
            .post(post)
            .commentContent(commentRequest.getCommentContent())
            .build();
        commentRepository.save(comment);

        CommentDto commentDto = commentRepository.getCommentDtoByCommentNo(comment.getCommentNo());
        return commentDto;
    }

    @Transactional
    @Override
    public CommentDto modifyComment(Integer commentNo, CommentRequest commentRequest) {
        return null;
    }

    @Transactional
    @Override
    public Integer deleteComment(Integer commentNo) {
        return null;
    }
}
