package com.nhnacademy.springjpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 404484226L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final ListPath<Comment, QComment> comments = this.<Comment, QComment>createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);

    public final NumberPath<Integer> depth = createNumber("depth", Integer.class);

    public final ArrayPath<byte[], Byte> fileData = createArray("fileData", byte[].class);

    public final StringPath fileName = createString("fileName");

    public final ListPath<Good, QGood> goods = this.<Good, QGood>createList("goods", Good.class, QGood.class, PathInits.DIRECT2);

    public final NumberPath<Integer> parent = createNumber("parent", Integer.class);

    public final BooleanPath postCheckHide = createBoolean("postCheckHide");

    public final StringPath postContent = createString("postContent");

    public final DateTimePath<java.time.LocalDateTime> postModifyDateTime = createDateTime("postModifyDateTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> postNo = createNumber("postNo", Integer.class);

    public final StringPath postTitle = createString("postTitle");

    public final DateTimePath<java.time.LocalDateTime> postWriteDateTime = createDateTime("postWriteDateTime", java.time.LocalDateTime.class);

    public final QUser user;

    public final ListPath<View, QView> views = this.<View, QView>createList("views", View.class, QView.class, PathInits.DIRECT2);

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

