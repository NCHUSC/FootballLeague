package com.example.model;

/**
 * 球队实体类
 */
public class Team {

    /**
     * 球队 id
     */
    private int id;

    /**
     * 球队名称
     */
    private String teamName;

    /**
     * 球队简称
     */
    private String shorterName;

    /**
     * 队长姓名
     */
    private String captainName;

    /**
     * 队长联系方式
     */
    private String captainTel;

    /**
     * 主场
     */
    private String home;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 所参加联赛
     */
    private String league;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getShorterName() {
        return shorterName;
    }

    public void setShorterName(String shorterName) {
        this.shorterName = shorterName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getCaptainTel() {
        return captainTel;
    }

    public void setCaptainTel(String captainTel) {
        this.captainTel = captainTel;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", shorterName='" + shorterName + '\'' +
                ", captainName='" + captainName + '\'' +
                ", captainTel='" + captainTel + '\'' +
                ", home='" + home + '\'' +
                ", city='" + city + '\'' +
                ", league='" + league + '\'' +
                '}';
    }
}
