package com.ruoyi.tags.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 兴趣特征对象 tbl_users_preference
 * 
 * @author uus
 * @date 2024-03-15
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
    private Long frequency;

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

    /** 商品推荐top1 */
    @Excel(name = "商品推荐top1")
    private String top1;

    /** 商品推荐top2 */
    @Excel(name = "商品推荐top2")
    private String top2;

    /** 商品推荐top3 */
    @Excel(name = "商品推荐top3")
    private String top3;

    /** 商品推荐top4 */
    @Excel(name = "商品推荐top4")
    private String top4;

    /** 商品推荐top5 */
    @Excel(name = "商品推荐top5")
    private String top5;

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
    public void setFrequency(Long frequency) 
    {
        this.frequency = frequency;
    }

    public Long getFrequency() 
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
    public void setTop1(String top1) 
    {
        this.top1 = top1;
    }

    public String getTop1() 
    {
        return top1;
    }
    public void setTop2(String top2) 
    {
        this.top2 = top2;
    }

    public String getTop2() 
    {
        return top2;
    }
    public void setTop3(String top3) 
    {
        this.top3 = top3;
    }

    public String getTop3() 
    {
        return top3;
    }
    public void setTop4(String top4) 
    {
        this.top4 = top4;
    }

    public String getTop4() 
    {
        return top4;
    }
    public void setTop5(String top5) 
    {
        this.top5 = top5;
    }

    public String getTop5() 
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
