package com.example.model;

public class MatchInformation {

    //比赛信息id
    private int id;

    //所属联赛
    private String league;

    //所属轮次
    private String round;

    //比赛日期
    private String matchDate;

    //主队
    private String homeTeam;

    //客队
    private String guestTeam;

    //裁判
    private String referee;

    //比赛城市
    private String city;

    //比赛场地
    private String field;

    //球队
    private String team;

    //比赛状态
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "MatchInformation{" +
                "id=" + id +
                ", league='" + league + '\'' +
                ", round='" + round + '\'' +
                ", matchDate='" + matchDate + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", guestTeam='" + guestTeam + '\'' +
                ", referee='" + referee + '\'' +
                ", city='" + city + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
