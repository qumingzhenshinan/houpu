package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.VideoChildDao;
import com.jiuchou.houpu.entity.VideoChild;
import com.jiuchou.houpu.service.VideoChildService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service(value = "videoChildService")
public class VideoChildServiceImpl implements VideoChildService {

    @Resource
    public VideoChildDao videoChildDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public RestFulBean<VideoChild> select(String gid) {
        List<VideoChild> list = videoChildDao.queryChildById(gid);
        if (list != null && list.size() > 0) {
            VideoChildData videoChildData = new VideoChildData();
            videoChildData.setVideoChild(list);
            return RestFulUtil.getInstance().getResuFulBean(videoChildData, 200, "获取数据正常");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 201, "数据获取失败");
        }
    }
}

class VideoChildData{
    private List<VideoChild> videoChild;

    public List<VideoChild> getVideoChild() {
        return videoChild;
    }

    public void setVideoChild(List<VideoChild> videoChild) {
        this.videoChild = videoChild;
    }
}
