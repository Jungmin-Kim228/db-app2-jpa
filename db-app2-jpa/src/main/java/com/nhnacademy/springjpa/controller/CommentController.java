package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.Msg;
import com.nhnacademy.springjpa.domain.comment.CommentDto;
import com.nhnacademy.springjpa.domain.comment.CommentRequest;
import com.nhnacademy.springjpa.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public Msg createComment(@RequestBody CommentRequest commentRequest) {
        CommentDto commentDto = commentService.createComment(commentRequest);
        return Msg.success(commentDto);
    }

    @PostMapping(value = "/modify/{commentNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Msg modifyComment(@PathVariable("commentNo") Integer commentNo,
                             @RequestBody CommentRequest commentRequest) {
        CommentDto commentDto = commentService.modifyComment(commentNo, commentRequest);
        return Msg.success(commentDto);
    }

    @PostMapping(value = "/delete/{commentNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Msg deleteComment(@PathVariable("commentNo") Integer commentNo) {
        Integer deleteCommentNo = commentService.deleteComment(commentNo);
        return Msg.success(deleteCommentNo);
    }
}
