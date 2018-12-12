package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsDao {

    List<Questions> queryAll(String etid);


}
