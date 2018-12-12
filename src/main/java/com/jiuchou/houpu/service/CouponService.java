package com.jiuchou.houpu.service;

import com.jiuchou.houpu.entity.Coupon;
import com.jiuchou.houpu.util.RestFulBean;

public interface CouponService {
    RestFulBean<Coupon> selectAll(String uid);

    boolean insert(Coupon coupon);
}
