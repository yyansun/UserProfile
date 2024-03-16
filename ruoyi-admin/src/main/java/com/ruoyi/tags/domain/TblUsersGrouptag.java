package com.ruoyi.tags.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 组合标签对象 tbl_users_grouptag
 * 
 * @author uus
 * @date 2024-03-16
 */
public class TblUsersGrouptag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 职业 */
    @Excel(name = "职业")
    private Integer job;

    /** 年龄段 */
    @Excel(name = "年龄段")
    private String ageRange;

    /** 消费周期 */
    @Excel(name = "消费周期")
    private String consumptionCycle;

    /** 消费能力 */
    @Excel(name = "消费能力")
    private Integer rfm;

    /** 价格敏感度 */
    @Excel(name = "价格敏感度")
    private Integer psm;

    /** 最近登录 */
    @Excel(name = "最近登录")
    private Integer loginCycle;

    /** 访问频率 */
    @Excel(name = "访问频率")
    private Integer freqValue;

    /** 浏览时段 */
    @Excel(name = "浏览时段")
    private Integer timeSlot;

    /** 购物性别 */
    @Excel(name = "购物性别")
    private Integer usg;

    /** 活跃度 */
    @Excel(name = "活跃度")
    private Integer rfe;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }
    public void setJob(Integer job) 
    {
        this.job = job;
    }

    public Integer getJob() 
    {
        return job;
    }
    public void setAgeRange(String ageRange) 
    {
        this.ageRange = ageRange;
    }

    public String getAgeRange() 
    {
        return ageRange;
    }
    public void setConsumptionCycle(String consumptionCycle) 
    {
        this.consumptionCycle = consumptionCycle;
    }

    public String getConsumptionCycle() 
    {
        return consumptionCycle;
    }
    public void setRfm(Integer rfm) 
    {
        this.rfm = rfm;
    }

    public Integer getRfm() 
    {
        return rfm;
    }
    public void setPsm(Integer psm) 
    {
        this.psm = psm;
    }

    public Integer getPsm() 
    {
        return psm;
    }
    public void setLoginCycle(Integer loginCycle) 
    {
        this.loginCycle = loginCycle;
    }

    public Integer getLoginCycle() 
    {
        return loginCycle;
    }
    public void setFreqValue(Integer freqValue) 
    {
        this.freqValue = freqValue;
    }

    public Integer getFreqValue() 
    {
        return freqValue;
    }
    public void setTimeSlot(Integer timeSlot) 
    {
        this.timeSlot = timeSlot;
    }

    public Integer getTimeSlot() 
    {
        return timeSlot;
    }
    public void setUsg(Integer usg) 
    {
        this.usg = usg;
    }

    public Integer getUsg() 
    {
        return usg;
    }
    public void setRfe(Integer rfe) 
    {
        this.rfe = rfe;
    }

    public Integer getRfe() 
    {
        return rfe;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("gender", getGender())
            .append("job", getJob())
            .append("ageRange", getAgeRange())
            .append("consumptionCycle", getConsumptionCycle())
            .append("rfm", getRfm())
            .append("psm", getPsm())
            .append("loginCycle", getLoginCycle())
            .append("freqValue", getFreqValue())
            .append("timeSlot", getTimeSlot())
            .append("usg", getUsg())
            .append("rfe", getRfe())
            .toString();
    }
}
