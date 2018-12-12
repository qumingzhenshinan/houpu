package com.jiuchou.houpu.entity;


public class User {

  private String uid;
  private String userName;
  private String passWord;
  private String phoneNo;
  private String isVip;
  private String email;
  private String headImgUrl;
  private java.sql.Timestamp regTime;
  private java.sql.Timestamp lastLoginTime;
  private long type;
  private long status;
  private String freeType;
  private java.sql.Timestamp endTime;
  private long learnTime;
  private String rightContent;
  private String yqCode;
  private String yqCodeUrl;
  private String usedCode;


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }


  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }


  public String getIsVip() {
    return isVip;
  }

  public void setIsVip(String isVip) {
    this.isVip = isVip;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getHeadImgUrl() {
    return headImgUrl;
  }

  public void setHeadImgUrl(String headImgUrl) {
    this.headImgUrl = headImgUrl;
  }


  public java.sql.Timestamp getRegTime() {
    return regTime;
  }

  public void setRegTime(java.sql.Timestamp regTime) {
    this.regTime = regTime;
  }


  public java.sql.Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(java.sql.Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getFreeType() {
    return freeType;
  }

  public void setFreeType(String freeType) {
    this.freeType = freeType;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public long getLearnTime() {
    return learnTime;
  }

  public void setLearnTime(long learnTime) {
    this.learnTime = learnTime;
  }


  public String getRightContent() {
    return rightContent;
  }

  public void setRightContent(String rightContent) {
    this.rightContent = rightContent;
  }


  public String getYqCode() {
    return yqCode;
  }

  public void setYqCode(String yqCode) {
    this.yqCode = yqCode;
  }


  public String getYqCodeUrl() {
    return yqCodeUrl;
  }

  public void setYqCodeUrl(String yqCodeUrl) {
    this.yqCodeUrl = yqCodeUrl;
  }


  public String getUsedCode() {
    return usedCode;
  }

  public void setUsedCode(String usedCode) {
    this.usedCode = usedCode;
  }

}
