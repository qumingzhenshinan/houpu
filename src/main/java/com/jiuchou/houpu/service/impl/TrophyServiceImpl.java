package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.TrophyDao;
import com.jiuchou.houpu.entity.Trophy;
import com.jiuchou.houpu.service.TrophyService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "trophyService")
@Transactional
public class TrophyServiceImpl implements TrophyService {

    @Resource
    public TrophyDao trophyDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RestFulBean<Trophy> select() {
       List<Trophy> list = trophyDao.query();
       if(list!=null){
           TrophyData trophyData = new TrophyData();
           trophyData.setTrophy(list);
           return RestFulUtil.getInstance().getResuFulBean(trophyData,200,"获取数据正常");
       }else {
           return  RestFulUtil.getInstance().getResuFulBean(null,201,"暂时无数据哦！");
       }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RestFulBean<Trophy> queryById(String pid) {
        Trophy trophy = trophyDao.queryById(pid);
        if(trophy!=null){
            return RestFulUtil.getInstance().getResuFulBean(trophy,200,"获取数据正常");
        }else {
            return  RestFulUtil.getInstance().getResuFulBean(null,201,"暂时无数据哦！");
        }
    }
}
class TrophyData{
    private List<Trophy> trophyList;

    public List<Trophy> getTrophy() {
        return trophyList;
    }

    public void setTrophy(List<Trophy> trophyList) {
        this.trophyList = trophyList;
    }
}