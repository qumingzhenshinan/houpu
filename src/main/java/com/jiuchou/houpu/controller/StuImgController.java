package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.StuImg;
import com.jiuchou.houpu.service.StuImgService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
@RequestMapping("/stuimg")
public class StuImgController {
    @Autowired
    private StuImgService stuImgService;

    /**
     *@api {post} /stuimg/selectByProthyId  通过关联学员id获取学员证书图片
     *@apiVersion 0.1.0
     *@apiName  stuimg/selectByProthyId
     *@apiGroup  student
     *@apiDescription  通过关联学员id获取学员证书图片
     *@apiExample
     *@apiParam {String} pid  关联学员id
     *@apiSuccess {String} status=200
     */
    @RequestMapping("/selectByProthyId")
    @ResponseBody
    public RestFulBean<StuImg> selectByProthyId(String pid){
        RestFulBean<StuImg> lists = stuImgService.select(pid);
        return lists;
    }

}
