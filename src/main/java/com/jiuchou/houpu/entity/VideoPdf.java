package com.jiuchou.houpu.entity;


public class VideoPdf {

  private String pdfid;
  private String vid;
  private String pdfUrl;
  private long vctype;
  private long sort;


  public String getPdfid() {
    return pdfid;
  }

  public void setPdfid(String pdfid) {
    this.pdfid = pdfid;
  }


  public String getVid() {
    return vid;
  }

  public void setVid(String vid) {
    this.vid = vid;
  }


  public String getPdfUrl() {
    return pdfUrl;
  }

  public void setPdfUrl(String pdfUrl) {
    this.pdfUrl = pdfUrl;
  }


  public long getVctype() {
    return vctype;
  }

  public void setVctype(long vctype) {
    this.vctype = vctype;
  }


  public long getSort() {
    return sort;
  }

  public void setSort(long sort) {
    this.sort = sort;
  }

}
