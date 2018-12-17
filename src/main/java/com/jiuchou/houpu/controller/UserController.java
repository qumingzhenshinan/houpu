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
    @ResponseBody
    public void updateUserName(String uid, String userName) {
        userService.updateUserName(userName, uid);
    }

    /**
     * @api {post}   /user/profiles   修改用户头像
     * @apiVersion 0.1.0
     * @apiName user/profiles
     * @apiGroup user
     * @apiDescription 修改用户头像
     * @apiExample
     * @apiParam {String} uid 关联用户id
     * @apiParam {String}  profile   文件
     * @apiSuccess {String} status=200
     */
    @PutMapping("/profiles")
    public RestFulBean setUserProfile(@RequestParam(required = true) MultipartFile profile, String uid) {
        return userService.updHeadImgUrl(profile, uid);
    }

    /**
     * @api {post}   /user/login    用户登录
     * @apiVersion 0.1.0
     * @apiName user/login
     * @apiGroup user
     * @apiDescription 用户登录
     * @apiExample
     * @apiParam {String} phoneNo   用户名
     * @apiParam {String}  passWord  用户密码
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(String phoneNo, String passWord, HttpSession session) {
        User user = userService.login(phoneNo, passWord);
        if (user != null) {
            session.setAttribute("userlogin", user);
            return user;
        }
        return null;
    }

    /**
     * @api {post} /user/regist    用户注册
     * @apiVersion 0.1.0
     * @apiName user/regist
     * @apiGroup user
     * @apiDescription 用户注册
     * @apiExample
     * @apiParam {String} phoneNo  电话号码
     * @apiParam {String} validatacode  验证码
     * @apiParam {String}  passWord   密码
     * @apiSuccess {String} status=1,注册成功
     * @apiSuccess {String} status=2,注册失败
     * @apiSuccess {String} status=3,手机号已存在
     * @apiSuccess {String} status=4,信息输入有误
     *
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public int regist(HttpSession session, String phoneNo, String validatacode, String passWord) {
        int t = (Integer) session.getAttribute("ycodes");
        String s = ""+t;
        if (phoneNo != null && !"".equals(phoneNo) && validatacode != null && s.equals(validatacode) && passWord != null && !passWord.equals("")) {
            int i = userService.regist(phoneNo, passWord);
            return i;
        }else {
            return 4;
        }
    }
    /**
     * @api {post}  /user/updatePassWord   用户修改密码
     * @apiVersion 0.1.0
     * @apiName user/updatePassWord
     * @apiGroup user
     * @apiDescription 用户修改密码
     * @apiExample
     * @apiParam {String} password1  用户密码
     * @apiParam {String} password2  确认密码
     * @apiParam {String}   phoneNo   用户手机号
     * @apiSuccess {String} name Name of the User.
     */
    @RequestMapping(value = "/updatePassWord", method = RequestMethod.POST)
    @ResponseBody
    public int updatePassWord(String password1, String password2, String phoneNo) {
        return userService.updatePassWord(password1, password2, phoneNo);
    }

}
