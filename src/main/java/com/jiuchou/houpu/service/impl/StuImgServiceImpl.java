package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.StuImgDao;
import com.jiuchou.houpu.entity.StuImg;
import com.jiuchou.houpu.service.StuImgService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "stuImgService")
@Transactional
public class StuImgServiceImpl implements StuImgService {

    @Resource
    public StuImgDao stuImgDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RestFulBean<StuImg> select(String pid) {

        List<StuImg> list = stuImgDao.query(pid);
        if (list!=null && list.size()>0){
            StuImgData stuImgData = new StuImgData();
            stuImgData.setStuImg(list);
            return RestFulUtil.getInstance().getResuFulBean(stuImgData,200,"数据正常");
        }else{
            return RestFulUtil.getInstance().getResuFulBean(null,201,"未获取到数据");
        }
    }
}
class StuImgData{
    private List<StuImg> stuImgImg;

    public List<StuImg> getStuImg() {
        return stuImgImg;
    }

    public void setStuImg(List<StuImg> stuImgImg) {
        this.stuImgImg = stuImgImg;
    }
}