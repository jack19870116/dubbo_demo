package com.tiancaibao.pojo.user;

import java.io.Serializable;
import java.util.Date;

public class UserQuestionAnswers implements Serializable {
    private Integer id;

    private Long userId;

    private String answer1;

    private String answer2;

    private String answer3;

    private String answer4;

    private String answer5;

    private String answer6;

    private String answer7;

    private String answer8;

    private String answer9;

    private String answer10;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 客户类型(稳健型：steady；成长型：growth；进取型：aggressive)
     */
    private String type;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1 == null ? null : answer1.trim();
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2 == null ? null : answer2.trim();
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3 == null ? null : answer3.trim();
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4 == null ? null : answer4.trim();
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5 == null ? null : answer5.trim();
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6 == null ? null : answer6.trim();
    }

    public String getAnswer7() {
        return answer7;
    }

    public void setAnswer7(String answer7) {
        this.answer7 = answer7 == null ? null : answer7.trim();
    }

    public String getAnswer8() {
        return answer8;
    }

    public void setAnswer8(String answer8) {
        this.answer8 = answer8 == null ? null : answer8.trim();
    }

    public String getAnswer9() {
        return answer9;
    }

    public void setAnswer9(String answer9) {
        this.answer9 = answer9 == null ? null : answer9.trim();
    }

    public String getAnswer10() {
        return answer10;
    }

    public void setAnswer10(String answer10) {
        this.answer10 = answer10 == null ? null : answer10.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
        sb.append(", userId=").append(userId);
        sb.append(", answer1=").append(answer1);
        sb.append(", answer2=").append(answer2);
        sb.append(", answer3=").append(answer3);
        sb.append(", answer4=").append(answer4);
        sb.append(", answer5=").append(answer5);
        sb.append(", answer6=").append(answer6);
        sb.append(", answer7=").append(answer7);
        sb.append(", answer8=").append(answer8);
        sb.append(", answer9=").append(answer9);
        sb.append(", answer10=").append(answer10);
        sb.append(", score=").append(score);
        sb.append(", type=").append(type);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}