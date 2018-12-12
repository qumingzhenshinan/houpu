package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Exam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamDao {

    List<Exam> selectAll();

    List<Exam> selectByValue(@Param("s") String  s,@Param("value") String value);

    List<Exam> queryExamHistory(String uid);

    List<Exam> queryByEtid(String etid);

    List<String> etvalues();
}
