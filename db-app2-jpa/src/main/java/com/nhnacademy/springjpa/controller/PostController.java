package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts/{postNo}")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ModelAttribute(value = "post", binding = false)
    public PostDto getPost(@PathVariable("postNo") Integer postNo) {
        return postService.getPost(postNo);
    }

    @GetMapping
    public PostDto getPost(@ModelAttribute("post") PostDto post) {
        return post;
    }
}
