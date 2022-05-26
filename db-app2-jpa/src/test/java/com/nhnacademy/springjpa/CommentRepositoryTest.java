package com.nhnacademy.springjpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.domain.CommentDto;
import com.nhnacademy.springjpa.repository.CommentRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    void Test() {
        List<CommentDto> commentDtos = commentRepository.getCommentsByPost_PostNo(1);
        assertThat(commentDtos.get(0).getCommentContent()).isEqualTo("ㅇㅈ");
        System.out.println(commentDtos.get(0).getUser().getUserId());
    }
}
