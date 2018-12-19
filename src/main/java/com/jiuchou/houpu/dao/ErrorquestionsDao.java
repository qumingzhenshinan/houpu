package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Errorquestions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorquestionsDao {
    List<Errorquestions> queryByUid(@Param("uid") String uid,@Param("etid") String etid);

    boolean add(Errorquestions errorquestions);
}
