package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.VideoTest;
import com.jiuchou.houpu.util.RestFulBean;

 public interface VideoTestService {

    RestFulBean<VideoTest> select(String vcid);
}
