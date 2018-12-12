package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.GeneralvideoDao;
import com.jiuchou.houpu.entity.Generalvideo;
import com.jiuchou.houpu.service.GeneralvideoService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service(value = "generalvideoService")
@Transactional
public class GeneralvideoServiceImpl implements GeneralvideoService {

    @Resource
    public GeneralvideoDao generalvideoDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public RestFulBean<Generalvideo> selectAll() {
        List<Generalvideo> list = generalvideoDao.queryAll();
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public RestFulBean<Generalvideo> selectById(String gid) {
        Generalvideo generalvideo = generalvideoDao.queryById(gid);
        if (generalvideo != null) {
            return RestFulUtil.getInstance().getResuFulBean(generalvideo, 200, "数据获取正常");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 201, "当前无数据！");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public RestFulBean<Generalvideo> selectByKind(String gsbuject, String gclass, String gclassify) {
        List<Generalvideo> list = null;
        if ((gsbuject!=null||!gsbuject.equals(""))&&(gclass!=null||!gclass.equals(""))&&(gclassify!=null||!gclassify.equals(""))){
            list = generalvideoDao.queryByKind(gsbuject, gclass, gclassify);
        }else if ((gsbuject!=null||!gsbuject.equals(""))&&(gclass!=null||!gclass.equals(""))&&(gclassify==null||gclassify.equals(""))){
            list = generalvideoDao.queryByGsbujectAndGclass(gsbuject,gclass);
        }else if ((gsbuject!=null||!gsbuject.equals(""))&&(gclassify==null||!gclassify.equals(""))&&(gclass==null||gclass.equals(""))){
            list = generalvideoDao.queryByGsbujectAndGclassify(gsbuject, gclassify);
        }else if ((gsbuject==null||gsbuject.equals(""))&&(gclass!=null||!gclass.equals(""))&&(gclassify!=null||!gclassify.equals(""))){
            list = generalvideoDao.queryByGclassAndGclassify(gclass, gclassify);
        }else if ((gsbuject==null||gsbuject.equals(""))&&(gclass==null||gclass.equals(""))&&(gclassify!=null||!gclassify.equals(""))){
            list = generalvideoDao.queryByGclassify(gclassify);
        }else if ((gsbuject!=null||!gsbuject.equals(""))&&(gclass==null||gclass.equals(""))&&(gclassify==null||gclassify.equals(""))){
            list = generalvideoDao.queryByGsbuject(gsbuject);
        }else if ((gsbuject==null||gsbuject.equals(""))&&(gclass!=null||!gclass.equals(""))&&(gclassify==null||gclassify.equals(""))){
            list = generalvideoDao.queryByGclass(gclass);
        }
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public RestFulBean<Generalvideo> selectByTeacherId(String teacherId) {
        List<Generalvideo> list = generalvideoDao.queryByTeacherId(teacherId);
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectByCreatTime(String gsbuject,String gclass,String gclassify) {
        List<Generalvideo> list = generalvideoDao.queryByCreatTime(gsbuject,gclass,gclassify);
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectByMoney(String gsbuject,String gclass,String gclassify) {
        List<Generalvideo> list = generalvideoDao.queryByMoney(gsbuject,gclass,gclassify);
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectByKillEndTime() {
        List<Generalvideo> list = generalvideoDao.queryByKillEndTime(new Date());
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectRecommend(String uid, String etid) {
        List<Generalvideo> list = generalvideoDao.queryRecommend(uid,etid);
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectByValue(String value) {
        List<Generalvideo> list = generalvideoDao.queryByValue(value);
        return getGeneralvideoRestFulBean(list);
    }

    private RestFulBean<Generalvideo> getGeneralvideoRestFulBean(List<Generalvideo> list) {
        if (list != null && list.size() > 0) {
            GeneralvideoData generalvideoData = new GeneralvideoData();
            generalvideoData.setGeneralvideos(list);
            return RestFulUtil.getInstance().getResuFulBean(generalvideoData, 200, "数据获取正常");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 201, "当前无数据");
        }
    }


}


class GeneralvideoData {
    private List<Generalvideo> generalvideos;

    public List<Generalvideo> getGeneralvideos() {
        return generalvideos;
    }

    public void setGeneralvideos(List<Generalvideo> generalvideos) {
        this.generalvideos = generalvideos;
    }
}