package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.Comment;
import com.jiuchou.houpu.service.CommentService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/comment")
@Controller
@CrossOrigin
public class CommentController {

    @Autowired
    public CommentService commentService;


    /**
     * @api {post}  /comment/selectByGid   通过课程id查询所有评论
     * @apiVersion 0.1.0
     * @apiName comment/selectByGid
     * @apiGroup comment
     * @apiDescription 通过课程id查询所有评论
     * @apiExample
     * @apiParam {String} gid 关联课程id
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/selectByGid", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<Comment> select(String gid) {
        return commentService.select(gid);
    }


    /**
     * @api {post}  /comment/insert   添加评论
     * @apiVersion 0.1.0
     * @apiName comment/insert
     * @apiGroup comment
     * @apiDescription 添加评论
     * @apiExample
     * @apiParam {Object}  comment  获取前段数据以对象返回
     * @apiSuccess {String} status=200
     */
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public boolean insert(Comment comment) {
        boolean b = commentService.insert(comment);
        return b;
    }
}
