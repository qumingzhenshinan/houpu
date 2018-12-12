package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.VideoTestDao;
import com.jiuchou.houpu.entity.VideoTest;
import com.jiuchou.houpu.service.VideoTestService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "videoTestService")
@Transactional
public class VideoTestServiceImpl implements VideoTestService {

    @Resource
    public VideoTestDao videoTestDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public RestFulBean<VideoTest> select(String vcid) {
        VideoTest videoTest = videoTestDao.query(vcid);
        if (videoTest != null) {
            return RestFulUtil.getInstance().getResuFulBean(videoTest, 200, "数据查询正常");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null,201,"数据查询失败");
        }
    }
}