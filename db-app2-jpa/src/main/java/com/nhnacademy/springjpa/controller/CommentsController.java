package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.comment.CommentDto;
import com.nhnacademy.springjpa.service.CommentService;
import com.nhnacademy.springjpa.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments/{postNo}")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDto> getComments(@PathVariable("postNo") Integer postNo, Pageable pageable) {
        return commentService.getCommentsByPostNo(postNo, pageable).getContent();
    }
}
