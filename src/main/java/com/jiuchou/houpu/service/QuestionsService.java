package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Questions;
import com.jiuchou.houpu.util.RestFulBean;

public interface QuestionsService {

    RestFulBean<Questions> select(String etid);

}
