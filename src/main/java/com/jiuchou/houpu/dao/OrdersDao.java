package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {

    List<Orders> queryAll();

    List<Orders> queryByPay(String oisPay);

    boolean add(Orders orders);
}
