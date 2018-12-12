package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.Questions;
import com.jiuchou.houpu.service.QuestionsService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping(value = "/questions")
public class QuestionsController {

    @Autowired
    public QuestionsService questionsService;

    /**
     * @api {post}  /questions/select  查询某试卷下的所有试题
     * @apiVersion 0.1.0
     * @apiName questions/select
     * @apiGroup questions
     * @apiDescription 查询某试卷下的所有试题
     * @apiExample
     * @apiParam {String} etid 试卷id
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "select", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<Questions> select(String etid) {
        RestFulBean<Questions> questions = questionsService.select(etid);
        return questions;
    }


}
