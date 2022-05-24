package com.nhnacademy.springjpa.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

    @Column(name = "user_no")
    private Integer userNo;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_content")
    private String postContent;

    @Temporal(TemporalType.DATE)
    @Column(name = "post_write_datetime")
    private Date postWriteDateTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "post_modify_datetime")
    private Date postModifyDateTime;

    @Column(name = "post_check_hide")
    private Boolean postCheckHide;

    private Integer parent;

    @Column(name = "re_depth")
    private Integer depth;

    @Column(name = "file_name")
    private String fileName;
}
