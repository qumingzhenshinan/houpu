package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.ErrorquestionsDao;
import com.jiuchou.houpu.dao.ExamDao;
import com.jiuchou.houpu.dao.QuestionsDao;
import com.jiuchou.houpu.entity.Errorquestions;
import com.jiuchou.houpu.entity.Exam;
import com.jiuchou.houpu.entity.Questions;
import com.jiuchou.houpu.service.ExamService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service(value = "examService")
public class ExamServiceImpl implements ExamService {
    @Resource
    public ExamDao examDao;
    public QuestionsDao questionsDao;
    public ErrorquestionsDao errorquestionsDao;


    @Override
    public RestFulBean<Exam> selectAll() {
        List<Exam> list = examDao.selectAll();
        return getExamRestFulBean(list);
    }

    @Override
    public RestFulBean<Exam> selectByTxt(String value) {
        List<Exam> list = null;
        List<String> list1 = examDao.etvalues();
        for (int i = 0; i < list1.size() ; i ++) {
            String str = list1.get(i);
            if (value.equals(str)){
               //list = examDao.selectByEtsubject(str);
                list = examDao.selectByValue("etsubject",value);
               break;
            }else if(i == list1.size()-1){
             //   list = examDao.selectByEtname(str);
                list = examDao.selectByValue("etname",value);
            }
        }

        return getExamRestFulBean(list);
    }

    @Override
    public RestFulBean<Exam> selectExamHistory(String uid) {
        List<Exam> list = examDao.queryExamHistory(uid);
        return getExamRestFulBean(list);
    }

    @Override
    public double selectAnswer(String etid,Map<String,String> maps,String uid) throws RuntimeException{
        List<Questions> questions = questionsDao.queryAll(etid);
        Errorquestions errorquestions = new Errorquestions();
        double sum=0.0;
        try{
            if (maps!=null&&questions!=null){
                for (Map.Entry<String, String> entry : maps.entrySet()) {
                    for (int i = 0; i < questions.size(); i++) {
                        if (entry.getKey().equals(questions.get(i).getId())) {
                            if (entry.getValue().equals(questions.get(i).getAnswer())) {
                                sum += questions.get(i).getScore();
                            } else {
                                errorquestions.setEtid(questions.get(i).getEtid());
                                errorquestions.setName(questions.get(i).getName());
                                errorquestions.setContent(questions.get(i).getContent());
                                errorquestions.setScore(0);
                                errorquestions.setType(questions.get(i).getType());
                                errorquestions.setImg(questions.get(i).getImg());
                                errorquestions.setAnswer(questions.get(i).getAnswer());
                                errorquestions.setAnalysis(questions.get(i).getAnalysis());
                                errorquestions.setUid(uid);
                                boolean b = errorquestionsDao.add(errorquestions);
                            }
                        }
                    }
                }
                return sum;
            }else{
               throw new RuntimeException("数据有误!");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("数据有误!");
        }
    }

    private RestFulBean<Exam> getExamRestFulBean(List<Exam> list) {
        if (list != null && list.size() > 0) {
            ExamData examData = new ExamData();
            examData.setExams(list);
            return RestFulUtil.getInstance().getResuFulBean(examData, 200, "数据获取正常");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 201, "数据获取失败");
        }
    }
}


class ExamData{
    private List<Exam> exams;

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
}