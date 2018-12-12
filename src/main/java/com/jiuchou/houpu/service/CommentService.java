package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Comment;
import com.jiuchou.houpu.util.RestFulBean;

public interface CommentService {

    RestFulBean<Comment> select(String gid);

    boolean insert(Comment comment);
}
