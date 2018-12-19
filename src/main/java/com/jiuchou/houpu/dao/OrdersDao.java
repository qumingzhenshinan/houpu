package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {

    List<Orders> queryAll();

    List<Orders> queryByPay(String oisPay);

    boolean add(Orders orders);

    boolean update(@Param("isKill") int isKill,@Param("oid") String oid);
}
