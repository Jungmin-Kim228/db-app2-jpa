package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.Msg;
import com.nhnacademy.springjpa.domain.post.PostDto;
import com.nhnacademy.springjpa.domain.post.PostModifyDto;
import com.nhnacademy.springjpa.domain.post.PostRequest;
import com.nhnacademy.springjpa.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postNo}")
    public PostDto getPost(@PathVariable("postNo") Integer postNo) {
        return postService.getPost(postNo);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public Msg createPost(@RequestBody PostRequest postRequest) {
        PostDto postDto = postService.createPost(postRequest);
        return Msg.success(postDto);
    }

    @PostMapping(value = "/modify/{postNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Msg modifyPost(@PathVariable("postNo") Integer postNo,
                          @RequestBody PostRequest postRequest) {
        PostModifyDto postModifyDto = postService.modifyPost(postNo, postRequest);
        return Msg.success(postModifyDto);
    }

    @PostMapping(value = "/delete/{postNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Msg deletePost(@PathVariable("postNo") Integer postNo) {
        Integer deletePostNo = postService.deletePost(postNo);
        return Msg.success(deletePostNo);
    }
}
