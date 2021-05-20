package com.example.model;

/**
 * 球员实体类
 */
public class Player {

    /**
     * 球员 id
     */
    private Integer id;

    /**
     * 球员姓名
     */
    private String name;

    /**
     * 所属球队
     */
    private String team;

    /**
     * 球衣号码
     */
    private Integer number;

    /**
     * 场上位置
     */
    private String position;

    /**
     * 身高
     */
    private String height;

    /**
     * 身高范围（小）
     */
    private String minHeight;

    /**
     * 身高范围（大）
     */
    private String maxHeight;

    /**
     * 体重
     */
    private String weight;

    /**
     * 体重范围（小）
     */
    private String minWeight;

    /**
     * 体重范围（大）
     */
    private String maxWeight;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 年龄范围（小）
     */
    private Integer minAge;

    /**
     * 年龄范围（大）
     */
    private Integer maxAge;

    public String getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(String minHeight) {
        this.minHeight = minHeight;
    }

    public String getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(String maxHeight) {
        this.maxHeight = maxHeight;
    }

    public String getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(String minWeight) {
        this.minWeight = minWeight;
    }

    public String getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(String maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

