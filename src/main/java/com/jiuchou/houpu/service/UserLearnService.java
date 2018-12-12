package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Generalvideo;
import com.jiuchou.houpu.entity.UserLearn;
import com.jiuchou.houpu.util.RestFulBean;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserLearnService {

    RestFulBean<UserLearn> select(String userid);

    boolean insert(Generalvideo generalvideo,int learnTime,Date learnDate,String userId);
}
