package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Errorquestions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorquestionsDao {
    List<Errorquestions> queryByUid(String uid);

    boolean add(Errorquestions errorquestions);
}
