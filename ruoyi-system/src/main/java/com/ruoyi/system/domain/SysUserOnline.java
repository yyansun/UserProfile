package com.ruoyi.system.domain;
//ver1
/**
 * 当前在线会话
 * 
 * @author ruoyi
 */
public class SysUserOnline
{
    /** 会话编号 */
    //private String tokenId;

    /** 部门名称 */
    //private String deptName;

    /** 用户名称 */
    private String username;

    /** 登录IP地址 */
    //private String ipaddr;
    private Integer gender; //性别

    /** 登录地址 */
    //private String loginLocation;
    private String birthday; //生日

    /** 浏览器类型 */
    //private String browser;
    private Integer job; //职业

    /** 操作系统 */
    //private String os;
    private Integer politicalFace; //政治面貌

    /** 登录时间 */
    //private Long loginTime;
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

//    public String getTokenId()
//    {
//        return tokenId;
//    }

//    public void setTokenId(String tokenId)
//    {
//        this.tokenId = tokenId;
//    }

//    public String getDeptName()
//    {
//        return deptName;
//    }
//
//    public void setDeptName(String deptName)
//    {
//        this.deptName = deptName;
//    }

//    public String getUserName()
//    {
//        return userName;
//    }
//
//    public void setUserName(String userName)
//    {
//        this.userName = userName;
//    }
//
//    public String getIpaddr()
//    {
//        return ipaddr;
//    }
//
//    public void setIpaddr(String ipaddr)
//    {
//        this.ipaddr = ipaddr;
//    }
//
//    public String getLoginLocation()
//    {
//        return loginLocation;
//    }
//
//    public void setLoginLocation(String loginLocation)
//    {
//        this.loginLocation = loginLocation;
//    }
//
//    public String getBrowser()
//    {
//        return browser;
//    }
//
//    public void setBrowser(String browser)
//    {
//        this.browser = browser;
//    }
//
//    public String getOs()
//    {
//        return os;
//    }
//
//    public void setOs(String os)
//    {
//        this.os = os;
//    }
//
//    public Long getLoginTime()
//    {
//        return loginTime;
//    }
//
//    public void setLoginTime(Long loginTime)
//    {
//        this.loginTime = loginTime;
//    }
}
