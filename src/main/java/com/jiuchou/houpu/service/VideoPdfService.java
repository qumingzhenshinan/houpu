package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.VideoPdf;
import com.jiuchou.houpu.util.RestFulBean;

public interface VideoPdfService {

    RestFulBean<VideoPdf> select(String vcid);

}
