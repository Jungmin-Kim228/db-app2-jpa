package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.Msg;
import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.domain.PostRegisterRequest;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Msg createPost(@RequestBody PostRegisterRequest postRequest) {
        PostDto postDto = postService.createPost(postRequest);
        return Msg.success(postDto);
    }
}
