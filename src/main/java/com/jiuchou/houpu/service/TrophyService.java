package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Trophy;
import com.jiuchou.houpu.util.RestFulBean;


public interface TrophyService {
    RestFulBean<Trophy> select();

    RestFulBean<Trophy> queryById(String pid);
}
