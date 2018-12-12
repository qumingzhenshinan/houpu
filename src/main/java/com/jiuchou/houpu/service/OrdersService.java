package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Orders;
import com.jiuchou.houpu.util.RestFulBean;

public interface OrdersService {

    RestFulBean<Orders> selectAll();

    RestFulBean<Orders> selectByPay(String oisPay);

    Boolean insert(Orders orders);
}
