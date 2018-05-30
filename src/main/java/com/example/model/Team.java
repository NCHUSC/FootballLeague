package com.example.model;

public class Team {

    private int id ;

    private String teamName;

    private String shorterName;

    private String captainName;

    private String captainTel;

    private String home;

    private String city;

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
