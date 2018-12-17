package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.Generalvideo;
import com.jiuchou.houpu.service.GeneralvideoService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("/course")
public class GeneralvideoController {

    @Autowired
    public GeneralvideoService generalvideoService;

    /**
     * @api {get} /course/select 获取所有课程
     * @apiVersion 0.1.0
     * @apiName course/select
     * @apiGroup course
     * @apiDescription 获取所有课程
     * @apiExample
     * @apiParam {Number} user_id The user’s unique ID.
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/select")
    @ResponseBody
    public RestFulBean<Generalvideo> select() {
        RestFulBean<Generalvideo> lists = generalvideoService.selectAll();
        return lists;
    }

    /**
     * @api {post} /course/selectById  通过ID获取课程详情章节列表
     * @apiVersion 0.1.0
     * @apiName course/selectById
     * @apiGroup course
     * @apiDescription 通过ID获取课程详情章节列表
     * @apiExample
     * @apiParam {String} gid 主键gid
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<Generalvideo> selectById(String gid) {
        RestFulBean<Generalvideo> generalvideo = generalvideoService.selectById(gid);
        return generalvideo;
    }

    /**
     * @api {post} /course/selectByKind  课程三级分类查询
     * @apiVersion 0.1.0
     * @apiName course/selectByKind
     * @apiGroup course
     * @apiDescription 课程三级分类查询
     * @apiExample
     * @apiParam {String} gsbuject 课程分类
     * @apiParam {String} gclass 年级分类
     * @apiParam {String} gclassify 专题（长期）分类
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/selectByKind", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<Generalvideo> selectByKind(String gsbuject, String gclass, String gclassify) {
        RestFulBean<Generalvideo> generalvideos = generalvideoService.selectByKind(gsbuject, gclass, gclassify);
        return generalvideos;
    }

    /**
     * @api {post} /course/selectByTeacherId  老师详情页主讲课程查询
     * @apiVersion 0.1.0
     * @apiName course/selectByTeacherId
     * @apiGroup course
     * @apiDescription 老师详情页主讲课程查询
     * @apiExample
     * @apiParam {String} tid  教师id
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/selectByTeacherId", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<Generalvideo> selectByTeacherId(String tid) {
        RestFulBean<Generalvideo> generalvideos = generalvideoService.selectByTeacherId(tid);
        return generalvideos;
    }

    /**
     * @api {get}  /course/selectByCreatTime  通过时间降序来选取热门课程
     * @apiVersion 0.1.0
     * @apiName course/selectByCreatTime
     * @apiGroup   course
     * @apiDescription   通过时间降序来选取热门课程
     * @apiExample
     * @apiParam {Number} user_id The user’s unique ID.
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/selectByCreatTime", method = RequestMethod.GET)
    @ResponseBody
    public RestFulBean<Generalvideo> selectByCreatTime(String gsbuject, String gclass, String gclassify) {
        RestFulBean<Generalvideo> videos = generalvideoService.selectByCreatTime(gsbuject, gclass, gclassify);
        return videos;
    }

    /**
    *@api {post} /course/selectByMoney  0元体验列表
    *@apiVersion 0.1.0
    *@apiName   course/selectByMoney
    *@apiGroup   course
    *@apiDescription  0元体验列表
    *@apiExample
    *@apiParam {String} gmoney  课程价格
    *@apiSuccess {String} status=200
    */
    @ResponseBody
    @RequestMapping(value = "/selectByMoney", method = RequestMethod.POST)
    public RestFulBean<Generalvideo> selectByMoney(String gsbuject, String gclass, String gclassify){
        RestFulBean<Generalvideo> list = generalvideoService.selectByMoney(gsbuject, gclass, gclassify);
        return list;
    }
    /**
    *@api {get}  /course/selectKillEndTime  限时促销
    *@apiVersion 0.1.0
    *@apiName  course/selectKillEndTime
    *@apiGroup   course
    *@apiDescription   限时促销
    *@apiExample
    *@apiParam {Number} user_id The user’s unique ID.
    *@apiSuccess {String} status=200
    */
    @RequestMapping(value = "/selectKillEndTime", method = RequestMethod.GET)
    @ResponseBody
    public RestFulBean<Generalvideo> selectKillEndTime(){
        return generalvideoService.selectByKillEndTime();
    }

    /**
    *@api {post}  /course/recommend    推荐课程
    *@apiVersion 0.1.0
    *@apiName  course/recommend
    *@apiGroup course
    *@apiDescription    推荐课程
    *@apiExample
    *@apiParam {String} userid 用户id
    *@apiParam {String} etid  试卷id
    *@apiSuccess {String} status=200
    */
    @RequestMapping(value = "/recommend",method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<Generalvideo> selectRecommend(String uid,String etid){
        return generalvideoService.selectRecommend(uid,etid);
    }

    /**
     *@api {post}  /course/selectByValue   课程模糊查询
     *@apiVersion 0.1.0
     *@apiName  course/selectByValue
     *@apiGroup course
     *@apiDescription    课程模糊查询
     *@apiExample
     *@apiParam {String} gname 用户输入字符串
     *@apiSuccess {String} status=200
     */
    @RequestMapping(value = "/selectByValue",method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<Generalvideo> selectByValue(String value){
        return generalvideoService.selectByValue(value);
    }

}
