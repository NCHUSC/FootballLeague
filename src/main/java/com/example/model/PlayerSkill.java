package com.example.model;

public class PlayerSkill {

    //球员id
    private Integer id;

    //球员姓名
    private String name;

    //球衣号码
    private Integer number;

    //球员总进球数
    private Integer goals;

    //球员数据id
    private Integer resultId;

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }
}
