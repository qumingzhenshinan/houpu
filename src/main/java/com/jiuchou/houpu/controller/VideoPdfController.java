package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.VideoPdf;
import com.jiuchou.houpu.service.VideoPdfService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/videoPdf")
public class VideoPdfController {

    @Autowired
    public VideoPdfService videoPdfService;

    /**
     * @api {post} /videoPdf/select  通过视频id获取对应讲义
     * @apiVersion 0.1.0
     * @apiName videoPdf/select
     * @apiGroup videoPdf
     * @apiDescription 通过视频id获取对应讲义
     * @apiExample
     * @apiParam {String} vcid  视频id
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<VideoPdf> select(String vcid) {
        RestFulBean<VideoPdf> videoPdf = videoPdfService.select(vcid);
        return videoPdf;
    }
}
