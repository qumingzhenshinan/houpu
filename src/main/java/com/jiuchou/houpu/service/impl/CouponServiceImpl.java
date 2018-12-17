package com.jiuchou.houpu.service.impl;

import com.jiuchou.houpu.dao.CouponDao;
import com.jiuchou.houpu.entity.Coupon;
import com.jiuchou.houpu.service.CouponService;
import com.jiuchou.houpu.util.RestFulBean;
import com.jiuchou.houpu.util.RestFulUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "couponService")
@Transactional
public class CouponServiceImpl implements CouponService {

    @Resource
    public CouponDao couponDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public RestFulBean<Coupon> selectAll(String uid) {
        List<Coupon> list = couponDao.queryAll(uid);
        return getCouponRestFulBean(list);
    }

    @Override
    public boolean insert(Coupon coupon) {
        Coupon c = new Coupon();
        c.setCname(coupon.getCname());
        c.setCtype(coupon.getCtype());
        c.setValidity(coupon.getValidity());
        c.setCouponPrice(coupon.getCouponPrice());
        c.setUid(coupon.getUid());
        boolean b = couponDao.add(c);
        if(b){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public RestFulBean<Coupon> selectByCtype(String uid, String ctype) {
        List<Coupon> list = couponDao.queryByCtype(uid,ctype);
        return getCouponRestFulBean(list);
    }

    private RestFulBean<Coupon> getCouponRestFulBean(List<Coupon> list) {
        if (list != null && list.size() > 0) {
            CouponData couponData = new CouponData();
            couponData.setCoupons(list);
            return RestFulUtil.getInstance().getResuFulBean(couponData, 200, "获取数据正常");
        } else {
            return RestFulUtil.getInstance().getResuFulBean(null, 201, "获取数据失败");
        }
    }


}



class CouponData{
    private List<Coupon> coupons;

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
}