package com.jiuchou.houpu.entity;


public class Orders {

  private String oid;
  private String omoney;
  private java.sql.Timestamp ocreatTime;
  private java.sql.Timestamp opayTime;
  private String oisPay;
  private String orderNo;
  private String uid;
  private String vid;
  private String vclassify;
  private String payStyle;
  private long isKill;
  private String costPrice;
  private String preferentialPrice;


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }


  public String getOmoney() {
    return omoney;
  }

  public void setOmoney(String omoney) {
    this.omoney = omoney;
  }


  public java.sql.Timestamp getOcreatTime() {
    return ocreatTime;
  }

  public void setOcreatTime(java.sql.Timestamp ocreatTime) {
    this.ocreatTime = ocreatTime;
  }


  public java.sql.Timestamp getOpayTime() {
    return opayTime;
  }

  public void setOpayTime(java.sql.Timestamp opayTime) {
    this.opayTime = opayTime;
  }


  public String getOisPay() {
    return oisPay;
  }

  public void setOisPay(String oisPay) {
    this.oisPay = oisPay;
  }


  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getVid() {
    return vid;
  }

  public void setVid(String vid) {
    this.vid = vid;
  }


  public String getVclassify() {
    return vclassify;
  }

  public void setVclassify(String vclassify) {
    this.vclassify = vclassify;
  }


  public String getPayStyle() {
    return payStyle;
  }

  public void setPayStyle(String payStyle) {
    this.payStyle = payStyle;
  }


  public long getIsKill() {
    return isKill;
  }

  public void setIsKill(long isKill) {
    this.isKill = isKill;
  }


  public String getCostPrice() {
    return costPrice;
  }

  public void setCostPrice(String costPrice) {
    this.costPrice = costPrice;
  }


  public String getPreferentialPrice() {
    return preferentialPrice;
  }

  public void setPreferentialPrice(String preferentialPrice) {
    this.preferentialPrice = preferentialPrice;
  }

}
