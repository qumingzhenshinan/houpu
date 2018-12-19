package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.OrdersDao;
import com.jiuchou.houpu.entity.Orders;
import com.jiuchou.houpu.service.OrdersService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
@Transactional
@Service(value = "ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Resource
    public OrdersDao ordersDao;

    @Override
    public RestFulBean<Orders> selectAll() {
        List<Orders> list = ordersDao.queryAll();
        return getOrdersRestFulBean(list);
    }

    @Override
    public RestFulBean<Orders> selectByPay(String oisPay) {
        List<Orders> list = ordersDao.queryByPay(oisPay);
        return getOrdersRestFulBean(list);
    }

    @Override
    public Boolean insert(Orders orders) {
        String s = UUID.randomUUID().toString();
        Orders order = new Orders();
        order.setOid(s);
        order.setOmoney(null);
        order.setOcreatTime(orders.getOcreatTime());
        order.setOpayTime(orders.getOpayTime());
        order.setOisPay(orders.getOisPay());
        order.setOrderNo(orders.getOrderNo());
        order.setUid(orders.getUid());
        order.setVid(orders.getVid());
        order.setVclassify(orders.getVclassify());
        order.setPayStyle(orders.getPayStyle());
        order.setIsKill(orders.getIsKill());
        order.setCostPrice(orders.getCostPrice());
        order.setPreferentialPrice(orders.getPreferentialPrice());
        boolean b = ordersDao.add(order);
        if (b) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(int isKill, String oid) {
        boolean b = ordersDao.update(isKill,oid);
        if (b){
            return true;
        }
        return false;
    }

    private RestFulBean<Orders> getOrdersRestFulBean(List<Orders> list) {
        if (list != null && list.size() > 0) {
            OrdersData ordersData = new OrdersData();
            ordersData.setOrders(list);
            return RestFulUtil.getInstance().getResuFulBean(ordersData, 200, "数据访问正常");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 201, "数据访问失败");
        }
    }
}



class OrdersData{
    private List<Orders> orders;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}