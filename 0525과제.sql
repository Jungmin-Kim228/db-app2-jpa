use nhn_academy_8;

drop table if exists Users;
drop table if exists Posts;
drop table if exists Comments;
drop table if exists Likes;
drop table if exists Views;

create table if not exists Users (
	user_no int not null auto_increment,
    user_id varchar(20) not null,
    user_pw varchar(20) not null,
    check_admin boolean not null,
    primary key(user_no)
);

create table if not exists Posts (
	post_no int not null auto_increment,
    user_no int not null,
    post_title varchar(20) not null,
    post_content varchar(100) not null,
    post_write_datetime datetime not null,
    post_modify_datetime datetime null,
    post_check_hide boolean not null,
    file_name varchar(50) null,
    file_data longblob null,
    parent int not null,
    re_depth int not null,
    primary key(post_no)
);

create table if not exists Comments (
	comment_no int not null auto_increment,
    post_no int not null,
    user_no int not null,
    comment_content varchar(50) not null,
    primary key(comment_no, post_no)
);

create table if not exists Likes (
	like_no int not null auto_increment,
    post_no int not null,
    user_no int not null,
    primary key(like_no, post_no)
);

create table if not exists Views (
	post_no int not null,
	user_no int not null,
    primary key(post_no, user_no)
);

select * from Comments;
select * from Likes;
select * from Posts;
select * from Users;
select * from Views;

insert into Users values (null, "userId11", "userPw11", false);
insert into Users values (null, "userId11111", "userPw11111", false);
insert into Users values (null, "userId3", "userPw3", false);

insert into Posts values (null, 1, "우식이", "귀엽지않음?", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 1, "thisIsTitle2", "content2", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 2, "title3", "content3", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 3, "title4", "content4", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 3, "title5", "content5", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 3, "thisIsNotTitle6", "content6", now(), null, false, null, null, 0, 0);

insert into Comments values (null, 1, 1, "ㅇㅈ");
insert into Comments values (null, 1, 2, "우시기 보고싶다....");
insert into Comments values (null, 1, 2, "언제 볼 수 있음?ㅠㅠ");
commit;

-- 1번 post의 모든 comment 조회
select C.comment_content from Posts P left join Comments C on C.post_no = P.post_no;

-- title에 'Is'가 들어간 post 조회
select * from Posts where post_title like '%Is%';

