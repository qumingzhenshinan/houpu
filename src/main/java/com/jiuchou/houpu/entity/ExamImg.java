package com.jiuchou.houpu.entity;


public class ExamImg {

  private String id;
  private String exid;
  private String examUrl;
  private String answerUrl;
  private long type;
  private long sort;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getExid() {
    return exid;
  }

  public void setExid(String exid) {
    this.exid = exid;
  }


  public String getExamUrl() {
    return examUrl;
  }

  public void setExamUrl(String examUrl) {
    this.examUrl = examUrl;
  }


  public String getAnswerUrl() {
    return answerUrl;
  }

  public void setAnswerUrl(String answerUrl) {
    this.answerUrl = answerUrl;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getSort() {
    return sort;
  }

  public void setSort(long sort) {
    this.sort = sort;
  }

}
