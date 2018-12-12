package com.jiuchou.houpu.entity;


public class Comment {

  private String cid;
  private String cgid;
  private String coid;
  private java.sql.Timestamp creatTime;
  private String score;
  private String content;
  private String cuid;


  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }


  public String getCgid() {
    return cgid;
  }

  public void setCgid(String cgid) {
    this.cgid = cgid;
  }


  public String getCoid() {
    return coid;
  }

  public void setCoid(String coid) {
    this.coid = coid;
  }


  public java.sql.Timestamp getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(java.sql.Timestamp creatTime) {
    this.creatTime = creatTime;
  }


  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getCuid() {
    return cuid;
  }

  public void setCuid(String cuid) {
    this.cuid = cuid;
  }

}
