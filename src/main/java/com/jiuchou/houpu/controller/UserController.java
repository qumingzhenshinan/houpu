package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.User;
import com.jiuchou.houpu.service.UserService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@CrossOrigin
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    public UserService userService;

    /**
     * @api {post}  /user/selectById   通过用户id 查询展示用户信息
     * @apiVersion 0.1.0
     * @apiName user/selectById
     * @apiGroup user
     * @apiDescription 通过用户id 查询展示用户信息
     * @apiExample
     * @apiParam {String} uid   主键用户id
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @ResponseBody
    public RestFulBean<User> selectById(String uid) {
        RestFulBean<User> user = userService.selectById(uid);
        return user;
    }

    /**
     * @api {post} /user/updateUserName  修改用户昵称s
     * @apiVersion 0.1.0
     * @apiName user/updateUserName
     * @apiGroup user
     * @apiDescription 修改用户昵称
     * @apiExample
     * @apiParam {String} uid  用户id
     * @apiParam {String} userName  修改的名称
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/updateUserName", method = RequestMethod.POST)
    public void updateUserName(String uid, String userName) {
        userService.updateUserName(userName, uid);
    }



    @PutMapping("/profiles")
    public RestFulBean setUserProfile(@RequestParam(required = true) MultipartFile profile,String uid) {
        return userService.updHeadImgUrl(profile,uid);
    }

   /* *//**
     * @api {post}  /user/updateHeadImgUrl   修改用户头像
     * @apiVersion 0.1.0
     * @apiName user/updateHeadImgUrl
     * @apiGroup user
     * @apiDescription 修改用户头像
     * @apiExample
     * @apiParam {String} uid  用户id
     * @apiParam {String} headImgUrl  修改的头像
     * @apiSuccess {String} status=200
     *//*
    @RequestMapping(value = "/updateHeadImgUrl", method = RequestMethod.POST)
    public void updateHeadImgUrl(String uid, String headImgUrl) {
        userService.updateHeadImgUrl(headImgUrl, uid);
    }
*/
    /**
     * @api {post}   /user/login    用户登录
     * @apiVersion 0.1.0
     * @apiName user/login
     * @apiGroup user
     * @apiDescription 用户登录
     * @apiExample
     * @apiParam {String} userName   用户名
     * @apiParam {String}  passWord  用户密码
     * @apiSuccess {String} name Name of the User.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(String userName, String passWord, HttpSession session) {
        User user = userService.login(userName, passWord);
        if (user != null) {
            session.setAttribute("userlogin", user);
        }
    }

    /**
     * @api {post} /user/regist    用户注册
     * @apiVersion 0.1.0
     * @apiName user/regist
     * @apiGroup user
     * @apiDescription 用户注册
     * @apiExample
     * @apiParam {User} user 前端回传用户对象
     * @apiParam {String} tel  电话号码
     * @apiParam {String} validatacode  验证码
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public boolean regist(HttpSession session, String tel, String validatacode) {
        String s = (String) session.getAttribute("ycodes");
        if (tel != null && !"".equals(tel) && validatacode != null && s.equals(validatacode)) {
            boolean b = userService.regist(tel);
            if (b) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
