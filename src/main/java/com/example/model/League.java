package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 联赛实体类
 */
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class League {

    /**
     * 联赛 id
     */
    @Id
    @GeneratedValue
    private int league_id;

    /**
     * 联赛名称
     */
    private String leagueName;

    /**
     * 联赛简称
     */
    private String shorterName;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;

    /**
     * 主办方
     */
    private String sponsor;

    /**
     * 联赛章程
     */
    private String constitution;

    /**
     * 赛事性质
     */
    private String level;

    /**
     * 赛事性别
     */
    private String gender;

    /**
     * 几人制联赛
     */
    private int number;

    /**
     * 半场时间
     */
    private String halfTime;

    /**
     * 中场休息时间
     */
    private String halfRelaxTime;

    /**
     * 弃权默认比人
     */
    private String abstentionScore;

    public League() {

    }

    public int getLeague_id() {
        return league_id;
    }

    public void setLeague_id(int league_id) {
        this.league_id = league_id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getShorterName() {
        return shorterName;
    }

    public void setShorterName(String shorterName) {
        this.shorterName = shorterName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(String halfTime) {
        this.halfTime = halfTime;
    }

    public String getHalfRelaxTime() {
        return halfRelaxTime;
    }

    public void setHalfRelaxTime(String halfRelaxTime) {
        this.halfRelaxTime = halfRelaxTime;
    }

    public String getAbstentionScore() {
        return abstentionScore;
    }

    public void setAbstentionScore(String abstentionScore) {
        this.abstentionScore = abstentionScore;
    }
}
