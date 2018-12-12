package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.QuestionsDao;
import com.jiuchou.houpu.entity.Questions;
import com.jiuchou.houpu.service.QuestionsService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service(value = "questionsService")
public class QuestionsServiceImpl implements QuestionsService {

    @Resource
    public QuestionsDao questionsDao;


    @Override
    public RestFulBean<Questions> select(String etid) {
        List<Questions> list = questionsDao.queryAll(etid);
        for (Questions q : list) {
            System.out.println(q.getName());
        }
        if (list!=null&&list.size()>0){
            QuestionsData questionsData = new QuestionsData();
            questionsData.setQuestions(list);
            return RestFulUtil.getInstance().getResuFulBean(questionsData,200,"数据查询正常");
        }else{
            return RestFulUtil.getInstance().getResuFulBean(null,201,"数据查询失败");
        }
    }

}

class QuestionsData{
    private List<Questions> questions;

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
}