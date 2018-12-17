package com.jiuchou.houpu.controller;

import com.alibaba.fastjson.JSONArray;
import com.jiuchou.houpu.entity.Exam;
import com.jiuchou.houpu.entity.Questions;
import com.jiuchou.houpu.service.ExamService;
import com.jiuchou.houpu.util.RestFulBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@Controller
@RequestMapping(value = "/exam")
public class ExamController {
    @Autowired
    public ExamService examService;

    /**
     * @api {get}  /exam/selectAll   查询所有试题
     * @apiVersion 0.1.0
     * @apiName exam/selectAll
     * @apiGroup exam
     * @apiDescription 查询所有试题
     * @apiExample
     * @apiParam {Number} user_id The user’s unique ID.
     * @apiSuccess {String} Status=200
     */
    @ResponseBody
    @RequestMapping(value = "/selectAll")
    public RestFulBean<Exam> selectAll() {
        return examService.selectAll();
    }


    /**
     * @api {post} /exam/selectByTxt   模糊查询
     * @apiVersion 0.1.0
     * @apiName exam/selectByTxt
     * @apiGroup exam
     * @apiDescription 模糊查询
     * @apiExample
     * @apiParam {String} s 页面输入的字段
     * @apiSuccess {String} status=200
     */
    @ResponseBody
    @RequestMapping(value = "/selectByTxt", method = RequestMethod.POST)
    public RestFulBean<Exam> selectByTxt(String value) {
        return examService.selectByTxt(value);
    }

    /**
     * @api {post}  /exam/selectExamHistoy   查询我做过的题目
     * @apiVersion 0.1.0
     * @apiName exam/selectExamHistoy
     * @apiGroup exam
     * @apiDescription 查询我做过的题目
     * @apiExample
     * @apiParam {String} uid The 关联用户id
     * @apiSuccess {String} status=200
     */

    @ResponseBody
    @RequestMapping(value = "/selectExamHistoy", method = RequestMethod.POST)
    public RestFulBean<Exam> selectExamHistoy(String uid) {
        return examService.selectExamHistory(uid);
    }


    /**
     * @api {post} /exam/selectAnswer   分数统计并添加错题
     * @apiVersion 0.1.0
     * @apiName exam/selectAnswer
     * @apiGroup exam
     * @apiDescription 分数统计并添加错题
     * @apiExample
     * @apiParam {String}  etid   所属试卷id
     * @apiParam {String}  questionsMap  试题集合
     * @apiParam {String}  uid   用户id
     * @apiSuccess {String} status=200
     */

    @RequestMapping(value = "/selectAnswer", method = RequestMethod.POST)
    @ResponseBody
    public double selectAnswer(String etid, @RequestBody Map questionsMap, String uid) {

        List<Questions> list=(List<Questions>) questionsMap.get("questions");//将返回的业务数据转换成list
        JSONArray jsonArray = new JSONArray(Collections.singletonList(list));//将list集合转换成json数组
        Map<String,String> maps = new HashMap<>();
        for (int i=0;i<jsonArray.size();i++){
          maps.put(((Questions)jsonArray.get(i)).getId(),((Questions)jsonArray.get(i)).getAnswer());
        }
        return examService.selectAnswer(etid, maps, uid);
    }
}
