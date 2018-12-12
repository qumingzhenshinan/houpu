package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Teacher;
import com.jiuchou.houpu.util.RestFulBean;

import java.util.List;

public interface TeacherService {
    RestFulBean<Teacher> select();

    RestFulBean<Teacher> queryById(String tid);
}
