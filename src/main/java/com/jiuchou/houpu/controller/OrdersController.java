package com.jiuchou.houpu.controller;

import com.jiuchou.houpu.entity.Orders;
import com.jiuchou.houpu.service.OrdersService;
import com.jiuchou.houpu.util.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    public OrdersService ordersService;

    /**
     * @api {get} /orders/selectAll  查询所有订单信息
     * @apiVersion 0.1.0
     * @apiName orders/selectAll
     * @apiGroup orders
     * @apiDescription 查询所有订单信息
     * @apiExample
     * @apiParam {Number} user_id The user’s unique ID.
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public RestFulBean<Orders> selectAll() {
        RestFulBean<Orders> orders = ordersService.selectAll();
        return orders;
    }

    /**
     * @api {post}  /orders/selectByPay  通过状态查询已支付、未支付
     * @apiVersion 0.1.0
     * @apiName orders/selectByPay
     * @apiGroup orders
     * @apiDescription 通过状态查询已支付和未支付
     * @apiExample
     * @apiParam {String} oisPay   支付状态（“0”未支付，“1”已支付）
     * @apiSuccess {String} status=200
     */
    @ResponseBody
    @RequestMapping(value = "/selectByPay", method = RequestMethod.POST)
    public RestFulBean<Orders> selectByPay(String oisPay) {
        RestFulBean<Orders> orders = ordersService.selectByPay(oisPay);
        return orders;
    }

    /**
     * @api {post}  /orders/insert  添加订单
     * @apiVersion 0.1.0
     * @apiName orders/insert
     * @apiGroup orders
     * @apiDescription 添加订单
     * @apiExample
     * @apiParam {Order} order   Orders对象
     * @apiSuccess {String} status=200
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public void insert(Orders orders) {
        ordersService.insert(orders);
    }

    /**
     * @api {post}   /orders/update    修改订单状态
     * @apiVersion 0.1.0
     * @apiName orders/update
     * @apiGroup orders
     * @apiDescription 修改订单状态
     * @apiExample
     * @apiParam {int} isKill  订单状态码（0 正常订单，1  取消的订单 , 2 过期的订单）
     * @apiParam  {String}  oid   订单id
     * @apiSuccess {String} status=200
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public boolean update(int isKill, String oid) {
        return ordersService.update(isKill, oid);
    }
}
