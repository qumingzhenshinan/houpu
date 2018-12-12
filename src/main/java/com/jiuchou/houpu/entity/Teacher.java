package com.jiuchou.houpu.entity;


public class Teacher {

  private String tid;
  private String tname;
  private String tintro;
  private String timgUrl;
  private long sort;
  private String subject;
  private String backImg;
  private long isShow;


  public String getTid() {
    return tid;
  }

  public void setTid(String tid) {
    this.tid = tid;
  }


  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }


  public String getTintro() {
    return tintro;
  }

  public void setTintro(String tintro) {
    this.tintro = tintro;
  }


  public String getTimgUrl() {
    return timgUrl;
  }

  public void setTimgUrl(String timgUrl) {
    this.timgUrl = timgUrl;
  }


  public long getSort() {
    return sort;
  }

  public void setSort(long sort) {
    this.sort = sort;
  }


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }


  public String getBackImg() {
    return backImg;
  }

  public void setBackImg(String backImg) {
    this.backImg = backImg;
  }


  public long getIsShow() {
    return isShow;
  }

  public void setIsShow(long isShow) {
    this.isShow = isShow;
  }

}
