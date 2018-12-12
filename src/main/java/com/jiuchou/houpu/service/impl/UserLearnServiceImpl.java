package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.UserLearnDao;
import com.jiuchou.houpu.entity.Generalvideo;
import com.jiuchou.houpu.entity.UserLearn;
import com.jiuchou.houpu.service.UserLearnService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service(value = "userLearnService")
@Transactional
public class UserLearnServiceImpl implements UserLearnService {

    @Resource
    public UserLearnDao userLearnDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RestFulBean<UserLearn> select(String userid) {
        List<UserLearn> list = userLearnDao.queryAll(userid);
        if (list!=null&&list.size()>0){
            UserLearnData userLearnData = new UserLearnData();
            userLearnData.setUserLearns(list);
            return RestFulUtil.getInstance().getResuFulBean(userLearnData,200,"数据正常");
        }else{
            return RestFulUtil.getInstance().getResuFulBean(null,201,"数据为空");
        }


    }

    @Override
    public boolean insert(Generalvideo generalvideo, int learnTime, Date learnDate, String userId) {
        String id = UUID.randomUUID().toString();
        UserLearn userLearn = new UserLearn();
        userLearn.setUlid(id);
        userLearn.setGid(generalvideo.getGid());
        userLearn.setVctype(generalvideo.getGclassify());
        userLearn.setLearnDate(learnDate);
        userLearn.setLearnTime(learnTime);
        userLearn.setUlid(userId);
        boolean b = userLearnDao.add(userLearn);
        if (b){
            return true;
        }else{
            return false;
        }
    }
}


class UserLearnData{

    private List<UserLearn> userLearns;

    public List<UserLearn> getUserLearns() {
        return userLearns;
    }

    public void setUserLearns(List<UserLearn> userLearns) {
        this.userLearns = userLearns;
    }
}