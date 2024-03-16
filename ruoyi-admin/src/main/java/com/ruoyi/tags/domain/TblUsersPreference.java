package com.ruoyi.tags.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 兴趣特征1对象 tbl_users_preference
 * 
 * @author uus
 * @date 2024-03-16
 */
public class TblUsersPreference extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 最近登录 */
    @Excel(name = "最近登录")
    private Integer loginCycle;

    /** 访问次数 */
    @Excel(name = "访问次数")
    private Integer frequency;

    /** 访问频率 */
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

    /** 商品推荐Top1 */
    @Excel(name = "商品推荐Top1")
    private Integer top1;

    /** 商品推荐Top2 */
    @Excel(name = "商品推荐Top2")
    private Integer top2;

    /** 商品推荐Top3 */
    @Excel(name = "商品推荐Top3")
    private Integer top3;

    /** 商品推荐Top4 */
    @Excel(name = "商品推荐Top4")
    private Integer top4;

    /** 商品推荐Top5 */
    @Excel(name = "商品推荐Top5")
    private Integer top5;

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
    public void setLoginCycle(Integer loginCycle) 
    {
        this.loginCycle = loginCycle;
    }

    public Integer getLoginCycle() 
    {
        return loginCycle;
    }
    public void setFrequency(Integer frequency) 
    {
        this.frequency = frequency;
    }

    public Integer getFrequency() 
    {
        return frequency;
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
    public void setTop1(Integer top1) 
    {
        this.top1 = top1;
    }

    public Integer getTop1() 
    {
        return top1;
    }
    public void setTop2(Integer top2) 
    {
        this.top2 = top2;
    }

    public Integer getTop2() 
    {
        return top2;
    }
    public void setTop3(Integer top3) 
    {
        this.top3 = top3;
    }

    public Integer getTop3() 
    {
        return top3;
    }
    public void setTop4(Integer top4) 
    {
        this.top4 = top4;
    }

    public Integer getTop4() 
    {
        return top4;
    }
    public void setTop5(Integer top5) 
    {
        this.top5 = top5;
    }

    public Integer getTop5() 
    {
        return top5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("loginCycle", getLoginCycle())
            .append("frequency", getFrequency())
            .append("freqValue", getFreqValue())
            .append("timeSlot", getTimeSlot())
            .append("usg", getUsg())
            .append("rfe", getRfe())
            .append("top1", getTop1())
            .append("top2", getTop2())
            .append("top3", getTop3())
            .append("top4", getTop4())
            .append("top5", getTop5())
            .toString();
    }
}
