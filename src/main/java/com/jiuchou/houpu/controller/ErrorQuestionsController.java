package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.Errorquestions;
import com.jiuchou.houpu.service.ErrorquestionsService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping(value = "/errorquestions")
public class ErrorQuestionsController {

    @Autowired
    public ErrorquestionsService errorquestionsService;

    /**
     * @api {post} /errorquestions/selectByUid  通过用户id查询错题
     * @apiVersion 0.1.0
     * @apiName errorquestions/selectByUid
     * @apiGroup errorquestions
     * @apiDescription 通过用户id查询错题
     * @apiExample
     * @apiParam {String} uid  用户id
     * @apiParam {String} etid  试卷id
     * @apiSuccess {String} status=200
     */
    @ResponseBody
    @RequestMapping(value = "/selectByUid", method = RequestMethod.POST)
    public RestFulBean<Errorquestions> selectByUid(String uid, String etid) {
        return errorquestionsService.selectByUid(uid, etid);
    }
}
