package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.Trophy;
import com.jiuchou.houpu.service.TrophyService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
@RequestMapping("/trophy")
public class TrophyController {
    @Autowired
    private TrophyService trophyService;
    /**
     *@api {get} /trophy/select  获取所有学员
     *@apiVersion 0.1.0
     *@apiName trophy/select
     *@apiGroup student
     *@apiDescription 获取所有学员
     *@apiExample
     *@apiParam {Number} user_id The user’s unique ID.
     *@apiSuccess {String} status=200
     */
    @RequestMapping("/select")
    @ResponseBody
    public RestFulBean<Trophy> select(){
        RestFulBean<Trophy> lists = trophyService.select();
        return lists;
    }

    /**
    *@api {post} /trophy/selectById 通过ID获取学员详情
    *@apiVersion 0.1.0
    *@apiName trophy/selectById
    *@apiGroup student
    *@apiDescription 通过ID获取学员详情
    *@apiExample
    *@apiParam {String}  pid  主键
    *@apiSuccess {String} status=200
    */
    @ResponseBody
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    public RestFulBean<Trophy> select(String pid){
        RestFulBean<Trophy> trophy = trophyService.queryById(pid);
        return trophy;
    }
}
