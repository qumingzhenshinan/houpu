package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.ArticleImg;
import com.jiuchou.houpu.service.ArticleImgService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
@RequestMapping("/article")
public class ArticleImgController {
    @Autowired
    private ArticleImgService articleImgService;

    /**
     *@api {get} /article/select  获取所有轮播图集合
     *@apiVersion 0.1.0
     *@apiName article/select
     *@apiGroup article
     *@apiDescription  获取所有轮播图集合
     *@apiExample
     *@apiSuccess {String} status=200
     */
    
    @RequestMapping("/select")
    @ResponseBody
    public RestFulBean<ArticleImg> select(){
        RestFulBean<ArticleImg> lists = articleImgService.select();
        return lists;
    }

}
