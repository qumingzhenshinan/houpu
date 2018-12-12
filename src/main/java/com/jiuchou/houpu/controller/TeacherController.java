package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.Teacher;
import com.jiuchou.houpu.service.TeacherService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    /**
    *@api {get} /teacher/select 获取老师列表
    *@apiVersion 0.1.0
    *@apiName  teacher/select
    *@apiGroup  Teather
    *@apiDescription  首页获取老师列表
    *@apiExample
    *@apiParam {Number} user_id The user’s unique ID.
    *@apiSuccess {String} status=200
    */
    @RequestMapping("/select")
    @ResponseBody
    public RestFulBean<Teacher> select(){
        RestFulBean<Teacher> lists = teacherService.select();
        return lists;
    }

    /**
     *@api {post} /teacher/selectById 根据ID获取老师详情
     *@apiVersion 0.1.0
     *@apiName  teacher/selectById
     *@apiGroup  Teather
     *@apiDescription  根据ID获取老师详情
     *@apiExample
     *@apiParam {String} tid 主键tid
     *@apiSuccess {String} status=200
     */
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<Teacher> selectById(String tid){
        RestFulBean<Teacher> teacher = teacherService.queryById(tid);
        return teacher;
    }

}
