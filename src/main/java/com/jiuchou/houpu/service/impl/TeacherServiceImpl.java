package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.TeacherDao;
import com.jiuchou.houpu.entity.Teacher;
import com.jiuchou.houpu.service.TeacherService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Resource
    public TeacherDao teacherDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RestFulBean<Teacher> select() {
        List<Teacher> list = teacherDao.query();
            if (list!=null && list.size()>0){
                TeacherData teacherData = new TeacherData();
                teacherData.setTeacher(list);
                return RestFulUtil.getInstance().getResuFulBean(teacherData,200,"数据正常");
            }else{
                return RestFulUtil.getInstance().getResuFulBean(null,201,"未获取到数据");
            }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RestFulBean<Teacher> queryById(String tid) {
        Teacher teacher = teacherDao.queryById(tid);
        if (teacher!=null){
            return RestFulUtil.getInstance().getResuFulBean(teacher,200,"数据正常");
        }else{
            return RestFulUtil.getInstance().getResuFulBean(null,201,"未获取到数据");
        }
    }
}






class TeacherData{
    private List<Teacher> teacher;

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }
}
