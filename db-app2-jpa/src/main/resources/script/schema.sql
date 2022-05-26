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

insert into Users values (null, "진하늘", "1111", false);
insert into Users values (null, "진남이", "2222", false);
insert into Users values (null, "진홍이", "3333", true);
insert into Users values (null, "진보라", "4444", false);
insert into Users values (null, "진하얀", "5555", false);

insert into Posts values (null, 1, "우식이", "귀엽지않음?", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 1, "thisIsTitle2", "content2", now(), null, true, null, null, 0, 0);
insert into Posts values (null, 2, "title3", "content3", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 3, "title4", "content4", now(), null, true, null, null, 0, 0);
insert into Posts values (null, 3, "title5", "content5", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 3, "thisIsNotTitle6", "content6", now(), null, true, null, null, 0, 0);
insert into Posts values (null, 1, "title7", "content7", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 1, "김우식", "웰시코기궁댕이", now(), null, true, null, null, 0, 0);
insert into Posts values (null, 2, "title9", "content9", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 3, "title10", "content10", now(), null, true, null, null, 0, 0);
insert into Posts values (null, 3, "title11", "content11", now(), null, false, null, null, 0, 0);
insert into Posts values (null, 3, "thisIsNotTitle12", "content12", now(), null, true, null, null, 0, 0);

insert into Comments values (null, 1, 1, "ㅇㅈ");
insert into Comments values (null, 1, 2, "우시기 보고싶다....");
insert into Comments values (null, 1, 2, "언제 볼 수 있음?ㅠㅠ");
insert into Comments values (null, 8, 5, "나도 만져볼래!!");
insert into Comments values (null, 8, 4, "나도나도!!!");
commit;