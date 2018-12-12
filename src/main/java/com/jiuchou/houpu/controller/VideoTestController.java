package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.VideoTest;
import com.jiuchou.houpu.service.VideoTestService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/videoTest")
public class VideoTestController {

    @Autowired
    public VideoTestService videoTestService;

    /**
     * @api {post} /videoTest/select  通过视频id获取对应测试
     * @apiVersion 0.1.0
     * @apiName videoTest/select
     * @apiGroup videoTest
     * @apiDescription 通过视频id获取对应测试
     * @apiExample
     * @apiParam {String} vcid  视频id
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<VideoTest> select(String vcid) {
        RestFulBean<VideoTest> videoTest = videoTestService.select(vcid);
        return videoTest;
    }
}
