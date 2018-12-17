package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Exam;
import com.jiuchou.houpu.util.RestFulBean;

import java.util.Map;

public interface ExamService {

    RestFulBean<Exam> selectAll();

    RestFulBean<Exam> selectByTxt(String value);

    RestFulBean<Exam> selectExamHistory(String uid);

    double selectAnswer(String etid, Map<String, String> questionsMap, String uid);
}
