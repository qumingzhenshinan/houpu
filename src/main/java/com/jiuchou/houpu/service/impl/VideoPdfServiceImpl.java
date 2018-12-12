package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.VideoPdfDao;
import com.jiuchou.houpu.entity.VideoPdf;
import com.jiuchou.houpu.service.VideoPdfService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service(value = "videoPdfService")
@Transactional
public class VideoPdfServiceImpl implements VideoPdfService {

    @Resource
    public VideoPdfDao videoPdfDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RestFulBean<VideoPdf> select(String vcid) {
        VideoPdf videoPdf = videoPdfDao.queryPdfById(vcid);
       if (videoPdf!=null){
           return RestFulUtil.getInstance().getResuFulBean(videoPdf,200,"获取数据正常");
       }else {
           return RestFulUtil.getInstance().getResuFulBean(null,201,"数据获取失败");
       }
    }
}
