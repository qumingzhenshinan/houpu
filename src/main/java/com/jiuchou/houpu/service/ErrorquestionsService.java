package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Errorquestions;
import com.jiuchou.houpu.util.RestFulBean;

public interface ErrorquestionsService {

    RestFulBean<Errorquestions> selectByUid(String uid,String etid);

}
