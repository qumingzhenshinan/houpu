package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherDao {
    List<Teacher> query();
    Teacher queryById(String tid);
}
