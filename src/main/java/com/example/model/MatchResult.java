package com.example.model;

public class MatchResult {

    private Integer rid;
    private String rleague;
    private String rmatchDate;
    private String rhomeTeam;
    private String rguestTeam;
    private String winner;
    private String score;
    private Integer homeGoals;
    private Integer guestGoals;
    private Integer matchId;

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRleague() {
        return rleague;
    }

    public void setRleague(String rleague) {
        this.rleague = rleague;
    }

    public String getRmatchDate() {
        return rmatchDate;
    }

    public void setRmatchDate(String rmatchDate) {
        this.rmatchDate = rmatchDate;
    }

    public String getRhomeTeam() {
        return rhomeTeam;
    }

    public void setRhomeTeam(String rhomeTeam) {
        this.rhomeTeam = rhomeTeam;
    }

    public String getRguestTeam() {
        return rguestTeam;
    }

    public void setRguestTeam(String rguestTeam) {
        this.rguestTeam = rguestTeam;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Integer getGuestGoals() {
        return guestGoals;
    }

    public void setGuestGoals(Integer guestGoals) {
        this.guestGoals = guestGoals;
    }
}
