package com.nhnacademy.springjpa.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private Integer postNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "post_write_datetime")
    private LocalDateTime postWriteDateTime;

    @Column(name = "post_modify_datetime")
    private LocalDateTime postModifyDateTime;

    @Column(name = "post_check_hide")
    private Boolean postCheckHide;

    private Integer parent;

    @Column(name = "re_depth")
    private Integer depth;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_data")
    private byte[] fileData;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Good> goods = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<View> views = new ArrayList<>();

//    public void addComment(Comment comment){
//        comment.setPost(this);
//        this.comments.add(comment);
//    }
    @Builder(builderMethodName = "addPost")
    public static Post createPost(User user, String postTitle, String postContent, String fileName, byte[] fileData) {
        Post post = new Post();
        post.setUser(user);
        post.setPostTitle(postTitle);
        post.setPostContent(postContent);
        post.setFileName(fileName);
        post.setFileData(fileData);
        post.setPostWriteDateTime(LocalDateTime.now());
        post.setPostCheckHide(false);
        post.setParent(0);
        post.setDepth(0);
        return post;
    }
}
