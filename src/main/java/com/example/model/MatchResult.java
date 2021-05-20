package com.example.model;

/**
 * 比赛结果实体类
 */
public class MatchResult {

    /**
     * 比赛结果 id
     */
    private Integer rid;

    /**
     * 所属联赛
     */
    private String rleague;

    /**
     * 比赛日期
     */
    private String rmatchDate;

    /**
     * 主队
     */
    private String rhomeTeam;

    /**
     * 客队
     */
    private String rguestTeam;

    /**
     * 比赛获胜方
     */
    private String winner;

    /**
     * 比分
     */
    private String score;

    /**
     * 主队进球数
     */
    private Integer homeGoals;

    /**
     * 客队进球数
     */
    private Integer guestGoals;

    /**
     * 所属比赛
     */
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
