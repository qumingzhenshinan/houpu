package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.Generalvideo;
import com.jiuchou.houpu.entity.UserLearn;
import com.jiuchou.houpu.service.UserLearnService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@CrossOrigin
@Controller
@RequestMapping(value = "/userlearn")
public class UserLearnController {

    @Autowired
    public UserLearnService userLearnService;

    /**
     * @api {post}  /userlearn/select  我看过的视频查询
     * @apiVersion 0.1.0
     * @apiName userlearn/select
     * @apiGroup userlearn
     * @apiDescription 我看过的视频查询
     * @apiExample
     * @apiParam {String} userid   用户id
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<UserLearn> select(String userid) {
        return userLearnService.select(userid);
    }

    /**
    *@api {post}   /userlearn/insert    我看过的视频添加功能
    *@apiVersion 0.1.0
    *@apiName   userlearn/insert
    *@apiGroup    userlearn
    *@apiDescription   我看过的视频添加功能
    *@apiExample
    *@apiParam {String} userId  用户关联的id
     * *@apiParam {int} learnTime  观看时长
     * *@apiParam {Date} learnDate  学习时间
     * *@apiParam {Generalvideo} generalvideo  点击时回传课程对象
    *@apiSuccess {String} status=200
    */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public boolean insert(Generalvideo generalvideo, int learnTime, Date learnDate, String userId) {
        return userLearnService.insert(generalvideo, learnTime, learnDate, userId);
    }
}
