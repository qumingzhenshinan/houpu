package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.VideoChild;
import com.jiuchou.houpu.service.VideoChildService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/videochild")
public class VideoChildController {

    @Autowired
    public VideoChildService videoChildService;

    /**
     * @api {post} /videochild/select  通过课程id获取对应章节
     * @apiVersion 0.1.0
     * @apiName videoChild/select
     * @apiGroup videoChild
     * @apiDescription 通过课程id获取对应章节
     * @apiExample
     * @apiParam {String} gid   课程id
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<VideoChild> select(String gid) {
        RestFulBean<VideoChild> videoChild = videoChildService.select(gid);
        return videoChild;
    }
}
