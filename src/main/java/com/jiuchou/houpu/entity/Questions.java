package com.jiuchou.houpu.entity;


import java.io.Serializable;

public class Questions{

  private int id;
  private String etid;
  private String name;
  private String content;
  private double score;
  private String type;
  private String img;
  private String answer;
  private String analysis;


  public String getId() {
    return ""+id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getEtid() {
    return etid;
  }

  public void setEtid(String etid) {
    this.etid = etid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public String getAnalysis() {
    return analysis;
  }

  public void setAnalysis(String analysis) {
    this.analysis = analysis;
  }

}
