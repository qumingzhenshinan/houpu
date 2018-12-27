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
        System.out.println(gclass + "" + gsbuject + "" + gclassify);
        List<Generalvideo> list = null;
        if ((gsbuject != null && !gsbuject.equals("")) && (gclass != null && !gclass.equals("")) && (gclassify != null && !gclassify.equals(""))) {
            list = generalvideoDao.queryByKind(gsbuject, gclass, gclassify);
        } else if ((gsbuject != null && !gsbuject.equals("")) && (gclass != null && !gclass.equals("")) && (gclassify == null || gclassify.equals(""))) {
            list = generalvideoDao.queryByGsbujectAndGclass(gsbuject, gclass);
        } else if ((gsbuject != null && !gsbuject.equals("")) && (gclassify != null && !gclassify.equals("")) && (gclass == null || gclass.equals(""))) {
            list = generalvideoDao.queryByGsbujectAndGclassify(gsbuject, gclassify);
        } else if ((gsbuject == null || gsbuject.equals("")) && (gclass != null && !gclass.equals("")) && (gclassify != null && !gclassify.equals(""))) {
            list = generalvideoDao.queryByGclassAndGclassify(gclass, gclassify);
        } else if ((gsbuject == null || gsbuject.equals("")) && (gclass == null || gclass.equals("")) && (gclassify != null && !gclassify.equals(""))) {
            list = generalvideoDao.queryByGclassify(gclassify);
        } else if ((gsbuject != null && !gsbuject.equals("")) && (gclass == null || gclass.equals("")) && (gclassify == null || gclassify.equals(""))) {
            list = generalvideoDao.queryByGsbuject(gsbuject);
        } else if ((gsbuject == null || gsbuject.equals("")) && (gclass != null && !gclass.equals("")) && (gclassify == null || gclassify.equals(""))) {
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
    public RestFulBean<Generalvideo> selectByCreatTime(String gsbuject, String gclass, String gclassify) {
        List<Generalvideo> list = generalvideoDao.queryByCreatTime(gsbuject, gclass, gclassify);
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectByMoney(String gsbuject, String gclass, String gclassify) {
        List<Generalvideo> list = generalvideoDao.queryByMoney(gsbuject, gclass, gclassify);
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectByKillEndTime() {
        List<Generalvideo> list = generalvideoDao.queryByKillEndTime(new Date());
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectRecommend(String uid, String etid) {
        List<Generalvideo> list = generalvideoDao.queryRecommend(uid, etid);
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectByValue(String value) {
        List<Generalvideo> list = null;
        List<String> list1 = generalvideoDao.queryGclass();
        List<String> list2 = generalvideoDao.queryGclassify();
        List<String> list3 = generalvideoDao.queryGname();
        List<String> list4 = generalvideoDao.queryGsbuject();
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        for (int i = 0; i < list1.size(); i++) { str1 = list1.get(i); }
        for (int j = 0; j < list2.size(); j++) { str2 = list2.get(j); }
        for (int k = 0; k < list3.size(); k++) { str3 = list3.get(k); }
        for (int l = 0; l < list4.size(); l++) { str4 = list4.get(l); }
        if (value.equals(str1)) {
            list = generalvideoDao.queryByValue("gclass", value);
        } else if (value.equals(str2)) {
            list = generalvideoDao.queryByValue("gclassify", value);
        } else if (value.equals(str3)) {
            list = generalvideoDao.queryByValue("gname", value);
        } else if (value.equals(str4)) {
            list = generalvideoDao.queryByValue("gsubject", value);
        }
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectAllByMoney() {
        List<Generalvideo> list = generalvideoDao.queryAllByMoney();
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<Generalvideo> selectAllByCreatTime() {
        List<Generalvideo> list = generalvideoDao.queryAllByCreatTime();
        return getGeneralvideoRestFulBean(list);
    }

    @Override
    public RestFulBean<String> selectGclass() {
        List<String> list = generalvideoDao.queryGclass();
        return getStringRestFulBean(list);
    }

    @Override
    public RestFulBean<String> selectGclassify() {
        List<String> list = generalvideoDao.queryGclassify();
        return getStringRestFulBean(list);
    }

    private RestFulBean<String> getStringRestFulBean(List<String> list) {
        if (list != null && list.size() > 0) {
            GeneralvideoData generalvideoData = new GeneralvideoData();
            generalvideoData.setLists(list);
            return RestFulUtil.getInstance().getResuFulBean(generalvideoData, 200, "种类已查出");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 201, "数据有误");
        }
    }

    @Override
    public RestFulBean<String> selectGsbuject() {
        List<String> list = generalvideoDao.queryGsbuject();
        return getStringRestFulBean(list);
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
    private List<String> lists;

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public List<Generalvideo> getGeneralvideos() {
        return generalvideos;
    }

    public void setGeneralvideos(List<Generalvideo> generalvideos) {
        this.generalvideos = generalvideos;
    }
}