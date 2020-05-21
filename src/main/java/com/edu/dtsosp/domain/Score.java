package com.edu.dtsosp.domain;

/**
 * @Classname score
 * @Description 成绩实体表
 */
public class Score {
    private Integer id;
    private Integer studentId;
    private double score1;
    private double score2;
    private double score3;
    private double score4;
    private double score5;
    private double score6;
    private String remark;

    private String studentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    public double getScore3() {
        return score3;
    }

    public void setScore3(double score3) {
        this.score3 = score3;
    }

    public double getScore4() {
        return score4;
    }

    public void setScore4(double score4) {
        this.score4 = score4;
    }

    public double getScore5() {
        return score5;
    }

    public void setScore5(double score5) {
        this.score5 = score5;
    }

    public double getScore6() {
        return score6;
    }

    public void setScore6(double score6) {
        this.score6 = score6;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString(){
        return "Score{"+"id="+id+",score1="+score1+",score2="+score2+",score3="+score3+",score4="+score4+",score5="+score5+",score6="+score6+",studentName="+studentName+"}";
    }
}
