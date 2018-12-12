package com.jiuchou.houpu.entity;


public class Coupon {

  private String cid;
  private String cname;
  private String ctype;
  private java.sql.Timestamp validity;
  private String couponPrice;
  private String uid;


  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }


  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }


  public String getCtype() {
    return ctype;
  }

  public void setCtype(String ctype) {
    this.ctype = ctype;
  }


  public java.sql.Timestamp getValidity() {
    return validity;
  }

  public void setValidity(java.sql.Timestamp validity) {
    this.validity = validity;
  }


  public String getCouponPrice() {
    return couponPrice;
  }

  public void setCouponPrice(String couponPrice) {
    this.couponPrice = couponPrice;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

}
