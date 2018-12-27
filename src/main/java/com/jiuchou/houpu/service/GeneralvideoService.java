package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Generalvideo;
import com.jiuchou.houpu.util.RestFulBean;

import java.util.Date;

public interface GeneralvideoService {
    RestFulBean<Generalvideo> selectAll();

    RestFulBean<Generalvideo> selectById(String gid);

    RestFulBean<Generalvideo> selectByKind(String gsbuject,String gclass,String gclassify);

    RestFulBean<Generalvideo> selectByTeacherId(String teacherId);

    RestFulBean<Generalvideo> selectByCreatTime(String gsbuject,String gclass,String gclassify);

    RestFulBean<Generalvideo> selectByMoney(String gsbuject,String gclass,String gclassify);

    RestFulBean<Generalvideo> selectByKillEndTime();

    RestFulBean<Generalvideo> selectRecommend(String uid,String etid);

    RestFulBean<Generalvideo> selectByValue(String value);

    RestFulBean<Generalvideo> selectAllByMoney();

    RestFulBean<Generalvideo> selectAllByCreatTime();

    RestFulBean<String> selectGclass();

    RestFulBean<String> selectGclassify();

    RestFulBean<String> selectGsbuject();
}
