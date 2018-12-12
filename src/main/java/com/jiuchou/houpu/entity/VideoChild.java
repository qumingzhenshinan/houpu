package com.jiuchou.houpu.entity;


public class VideoChild {

  private String vcid;
  private String pid;
  private String vcname;
  private String vcideoUrl;
  private String vclassify;
  private long vctype;
  private java.sql.Timestamp createtime;
  private long sort;
  private java.sql.Timestamp editDate;
  private String cImgUrl;


  public String getVcid() {
    return vcid;
  }

  public void setVcid(String vcid) {
    this.vcid = vcid;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public String getVcname() {
    return vcname;
  }

  public void setVcname(String vcname) {
    this.vcname = vcname;
  }


  public String getVcideoUrl() {
    return vcideoUrl;
  }

  public void setVcideoUrl(String vcideoUrl) {
    this.vcideoUrl = vcideoUrl;
  }


  public String getVclassify() {
    return vclassify;
  }

  public void setVclassify(String vclassify) {
    this.vclassify = vclassify;
  }


  public long getVctype() {
    return vctype;
  }

  public void setVctype(long vctype) {
    this.vctype = vctype;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public long getSort() {
    return sort;
  }

  public void setSort(long sort) {
    this.sort = sort;
  }


  public java.sql.Timestamp getEditDate() {
    return editDate;
  }

  public void setEditDate(java.sql.Timestamp editDate) {
    this.editDate = editDate;
  }


  public String getCImgUrl() {
    return cImgUrl;
  }

  public void setCImgUrl(String cImgUrl) {
    this.cImgUrl = cImgUrl;
  }

}
