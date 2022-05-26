//package com.nhnacademy.springjpa;
//
//import static org.mockito.Mockito.mock;
//
//import com.nhnacademy.springjpa.config.RootConfig;
//import com.nhnacademy.springjpa.config.WebConfig;
//import com.nhnacademy.springjpa.controller.PostsController;
//import com.nhnacademy.springjpa.repository.UserRepository;
//import com.nhnacademy.springjpa.service.PostService;
//import com.nhnacademy.springjpa.service.PostServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.ContextHierarchy;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//@Transactional
//@ContextHierarchy({
//    @ContextConfiguration(classes = RootConfig.class),
//    @ContextConfiguration(classes = WebConfig.class)
//})
//public class PostRestControllerTest {
//    private PostServiceImpl postService;
//    private UserRepository userRepository;
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        postService = mock(PostServiceImpl.class);
//        userRepository = mock(UserRepository.class);
//        mockMvc = MockMvcBuilders.standaloneSetup(
//            new PostsController(postService)).build();
//    }
//
//    @Test
//    void test() {
//        MvcResult mvcResult = mockMvc.perform(get("/posts"))
//    }
//}
