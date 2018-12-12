package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.Coupon;
import com.jiuchou.houpu.service.CouponService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping(value = "/coupon")
public class CouponController {

    @Autowired
    public CouponService couponService;

    /**
     * @api {post} /coupon/selectByUid   通过关联的用户id查询用户所有的优惠券列表
     * @apiVersion 0.1.0
     * @apiName coupon/selectByUid
     * @apiGroup coupon
     * @apiDescription 通过关联的用户id查询用户所有的优惠券列表
     * @apiExample
     * @apiParam {String} uid  关联用户的id
     * @apiSuccess {String} status=200
     */
    @ResponseBody
    @RequestMapping(value = "/selectByUid", method = RequestMethod.POST)
    public RestFulBean<Coupon> selectByUid(String uid) {
        RestFulBean<Coupon> list = couponService.selectAll(uid);
        return list;
    }

    /**
     * @api {post}  /coupon/insert  添加优惠券
     * @apiVersion 0.1.0
     * @apiName    coupon/insert
     * @apiGroup  coupon
     * @apiDescription   添加优惠券
     * @apiExample
     * @apiParam {Number} user_id The user’s unique ID.
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public boolean insert(Coupon coupon) {
        return couponService.insert(coupon);
    }
}
