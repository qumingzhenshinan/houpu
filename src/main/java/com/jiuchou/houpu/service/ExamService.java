package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Exam;
import com.jiuchou.houpu.util.RestFulBean;

public interface ExamService {

    RestFulBean<Exam> selectAll();

    RestFulBean<Exam> selectByTxt(String value);

    RestFulBean<Exam> selectExamHistory(String uid);

    double selectAnswer(Exam exam);
}
