package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.ErrorquestionsDao;
import com.jiuchou.houpu.entity.Errorquestions;
import com.jiuchou.houpu.service.ErrorquestionsService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service(value = "errorquestionsService")
public class ErrorquestionsServiceImpl implements ErrorquestionsService {

    @Resource
    public ErrorquestionsDao errorquestionsDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public RestFulBean<Errorquestions> selectByUid(String uid,String etid) {
        List<Errorquestions> list =  errorquestionsDao.queryByUid(uid,etid);
       if (list!=null&&list.size()>0){
           ErrorquestionsData errorquestionsData = new ErrorquestionsData();
           errorquestionsData.setErrorquestions(list);
           return RestFulUtil.getInstance().getResuFulBean(errorquestionsData,200,"数据获取正常");
       }else {
           return RestFulUtil.getInstance().getResuFulBean(null, 201, "数据获取失败");
       }
    }

}

class ErrorquestionsData{
    private List<Errorquestions> errorquestions;

    public List<Errorquestions> getErrorquestions() {
        return errorquestions;
    }

    public void setErrorquestions(List<Errorquestions> errorquestions) {
        this.errorquestions = errorquestions;
    }
}