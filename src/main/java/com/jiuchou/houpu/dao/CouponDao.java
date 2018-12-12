package com.jiuchou.houpu.dao;

import com.jiuchou.houpu.entity.Coupon;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponDao {

    List<Coupon> queryAll(String uid);

    boolean add(Coupon coupon);
}
