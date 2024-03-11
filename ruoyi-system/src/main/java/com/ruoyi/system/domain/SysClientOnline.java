package com.ruoyi.system.domain;

public class SysClientOnline {
    /** 用户名称 */
    private String username;
    private Integer gender; //性别
    private String birthday; //生日
    private Integer job; //职业
    private Integer politicalFace; //政治面貌
    private Integer region; //所属地区
    private Integer marriage; //婚姻状况
    private String mobile; //联系方式

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public Integer getPoliticalFace() {
        return politicalFace;
    }

    public void setPoliticalFace(Integer politicalFace) {
        this.politicalFace = politicalFace;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
