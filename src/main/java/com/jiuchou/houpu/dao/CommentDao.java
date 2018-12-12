package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    List<Comment> query(String gid);

    boolean add(Comment comment);
}
