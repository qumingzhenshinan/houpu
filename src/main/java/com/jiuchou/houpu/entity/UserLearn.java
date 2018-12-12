package com.jiuchou.houpu.entity;
import java.util.Date;

public class UserLearn {

  private String ulid;
  private String gid;
  private String vctype;
  private int learnTime;
  private Date learnDate;
  private String userId;


  public String getUlid() {
    return ulid;
  }

  public void setUlid(String ulid) {
    this.ulid = ulid;
  }

  public String getGid() {
    return gid;
  }

  public void setGid(String gid) {
    this.gid = gid;
  }

  public String getVctype() {
    return vctype;
  }

  public void setVctype(String vctype) {
    this.vctype = vctype;
  }

  public int getLearnTime() {
    return learnTime;
  }

  public void setLearnTime(int learnTime) {
    this.learnTime = learnTime;
  }

  public Date getLearnDate() {
    return learnDate;
  }

  public void setLearnDate(Date learnDate) {
    this.learnDate = learnDate;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
