package com.tiancaibao.pojo.user;

import java.io.Serializable;
import java.util.Date;

public class UserRiskAssessments implements Serializable {
    private Integer id;

    /**
     * 问卷标题
     */
    private String title;

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;

    private String answerE;

    private Integer scoreA;

    private Integer scoreB;

    private Integer scoreC;

    private Integer scoreD;

    private Integer scoreE;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA == null ? null : answerA.trim();
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB == null ? null : answerB.trim();
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC == null ? null : answerC.trim();
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD == null ? null : answerD.trim();
    }

    public String getAnswerE() {
        return answerE;
    }

    public void setAnswerE(String answerE) {
        this.answerE = answerE == null ? null : answerE.trim();
    }

    public Integer getScoreA() {
        return scoreA;
    }

    public void setScoreA(Integer scoreA) {
        this.scoreA = scoreA;
    }

    public Integer getScoreB() {
        return scoreB;
    }

    public void setScoreB(Integer scoreB) {
        this.scoreB = scoreB;
    }

    public Integer getScoreC() {
        return scoreC;
    }

    public void setScoreC(Integer scoreC) {
        this.scoreC = scoreC;
    }

    public Integer getScoreD() {
        return scoreD;
    }

    public void setScoreD(Integer scoreD) {
        this.scoreD = scoreD;
    }

    public Integer getScoreE() {
        return scoreE;
    }

    public void setScoreE(Integer scoreE) {
        this.scoreE = scoreE;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", answerA=").append(answerA);
        sb.append(", answerB=").append(answerB);
        sb.append(", answerC=").append(answerC);
        sb.append(", answerD=").append(answerD);
        sb.append(", answerE=").append(answerE);
        sb.append(", scoreA=").append(scoreA);
        sb.append(", scoreB=").append(scoreB);
        sb.append(", scoreC=").append(scoreC);
        sb.append(", scoreD=").append(scoreD);
        sb.append(", scoreE=").append(scoreE);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}