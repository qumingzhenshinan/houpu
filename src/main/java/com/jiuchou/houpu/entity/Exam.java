package com.jiuchou.houpu.entity;


import java.util.Map;

public class Exam {

    private String etid;
    private String etname;
    private String etsubject;
    private String etclass;
    private String etclassify;
    private String etimg;
    private java.sql.Timestamp etcreatTime;
    private String etestNo;
    private String answer;
    private String fmImg;
    private String pdf;
    private String answerPdf;
    private String teacherName;
    private String timeLength;
    private String content;
    private Map<String, String> questionsMap;//用户所作答的题答案集合
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength;
    }

    public Map<String, String> getQuestionsMap() {
        return questionsMap;
    }

    public void setQuestionsMap(Map<String, String> questionsMap) {
        this.questionsMap = questionsMap;
    }

    public String getEtid() {
        return etid;
    }

    public void setEtid(String etid) {
        this.etid = etid;
    }


    public String getEtname() {
        return etname;
    }

    public void setEtname(String etname) {
        this.etname = etname;
    }


    public String getEtsubject() {
        return etsubject;
    }

    public void setEtsubject(String etsubject) {
        this.etsubject = etsubject;
    }


    public String getEtclass() {
        return etclass;
    }

    public void setEtclass(String etclass) {
        this.etclass = etclass;
    }


    public String getEtclassify() {
        return etclassify;
    }

    public void setEtclassify(String etclassify) {
        this.etclassify = etclassify;
    }


    public String getEtimg() {
        return etimg;
    }

    public void setEtimg(String etimg) {
        this.etimg = etimg;
    }


    public java.sql.Timestamp getEtcreatTime() {
        return etcreatTime;
    }

    public void setEtcreatTime(java.sql.Timestamp etcreatTime) {
        this.etcreatTime = etcreatTime;
    }


    public String getEtestNo() {
        return etestNo;
    }

    public void setEtestNo(String etestNo) {
        this.etestNo = etestNo;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getFmImg() {
        return fmImg;
    }

    public void setFmImg(String fmImg) {
        this.fmImg = fmImg;
    }


    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }


    public String getAnswerPdf() {
        return answerPdf;
    }

    public void setAnswerPdf(String answerPdf) {
        this.answerPdf = answerPdf;
    }


    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

}
