package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.VideoChild;
import com.jiuchou.houpu.util.RestFulBean;

public interface VideoChildService {

    RestFulBean<VideoChild> select(String gid);
}
