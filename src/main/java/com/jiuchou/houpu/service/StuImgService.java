package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.StuImg;
import com.jiuchou.houpu.util.RestFulBean;


public interface StuImgService {
    RestFulBean<StuImg> select(String pid);
}
