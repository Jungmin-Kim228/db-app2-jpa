package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.post.PostDto;
import com.nhnacademy.springjpa.domain.post.PostModifyDto;
import com.nhnacademy.springjpa.domain.post.PostRequest;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import com.nhnacademy.springjpa.repository.PostRepository;
import com.nhnacademy.springjpa.repository.UserRepository;
import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostDto getPost(Integer no) {
        return postRepository.getPostDtoByPostNo(no);
    }

    @Override
    public Page<PostDto> getPosts(Pageable pageable) {
        return postRepository.getPostDtosAllBy(pageable);
    }

    @Transactional
    @Override
    public PostDto createPost(PostRequest postRequest) {
        User user = userRepository.getUserByUserNo(postRequest.getUserNo());
        Post post = Post.addPost()
            .user(user)
            .postTitle(postRequest.getPostTitle())
            .postContent(postRequest.getPostContent())
            .fileName(postRequest.getFileName())
            .fileData(postRequest.getFileData())
            .build();
        postRepository.save(post);

        PostDto postDto = postRepository.getPostDtoByPostNo(post.getPostNo());
        return postDto;
    }

    @Transactional
    @Override
    public PostModifyDto modifyPost(Integer postNo, PostRequest postRequest) {
        // 관리자가 수정자가 될 수 있기 때문에 request에서 받음
        User user = userRepository.getUserByUserNo(postRequest.getUserNo());
        Post post = postRepository.getPostByPostNo(postNo);
        post.setUser(user);
        post.setPostTitle(postRequest.getPostTitle());
        post.setPostContent(postRequest.getPostContent());
        post.setFileName(postRequest.getFileName());
        post.setFileData(postRequest.getFileData());
        post.setPostModifyDateTime(LocalDateTime.now());
        postRepository.save(post);

        PostModifyDto postModifyDto = postRepository.getPostModifyDtoByPostNo(post.getPostNo());
        return postModifyDto;
    }

    @Transactional
    @Override
    public Integer deletePost(Integer postNo) {
        Post post = postRepository.getPostByPostNo(postNo);
        postRepository.delete(post);

        return postNo;
    }
}
