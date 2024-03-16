package com.ruoyi.tags.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单人画像对象 tbl_user_profile
 * 
 * @author uus
 * @date 2024-03-16
 */
public class TblUserProfile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long userId;

    /** $column.columnComment */
    private String gender;

    /** $column.columnComment */
    private String job;

    /** $column.columnComment */
    private String nationality;

    /** $column.columnComment */
    private String marriage;

    /** $column.columnComment */
    private String politicalFace;

    /** $column.columnComment */
    private String isBlacklist;

    /** $column.columnComment */
    private String rfm;

    /** $column.columnComment */
    private String rfe;

    /** $column.columnComment */
    private String psm;

    /** $column.columnComment */
    private String usg;

    /** $column.columnComment */
    private String ageRange;

    /** $column.columnComment */
    private String buyFrequency;

    /** $column.columnComment */
    private String consumptionCycle;

    /** $column.columnComment */
    private String exchangeRate;

    /** $column.columnComment */
    private String loginCycle;

    /** $column.columnComment */
    private String logFrequency;

    /** $column.columnComment */
    private String logTimeSlot;

    /** $column.columnComment */
    private String maxOrderRange;

    /** $column.columnComment */
    private String payType;

    /** $column.columnComment */
    private String returnRate;

    /** $column.columnComment */
    private String unitPriceRange;

    /** $column.columnComment */
    private String BpTop1;

    /** $column.columnComment */
    private String BpTop2;

    /** $column.columnComment */
    private String BpTop3;

    /** $column.columnComment */
    private String BpTop4;

    /** $column.columnComment */
    private String BpTop5;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setJob(String job) 
    {
        this.job = job;
    }

    public String getJob() 
    {
        return job;
    }
    public void setNationality(String nationality) 
    {
        this.nationality = nationality;
    }

    public String getNationality() 
    {
        return nationality;
    }
    public void setMarriage(String marriage) 
    {
        this.marriage = marriage;
    }

    public String getMarriage() 
    {
        return marriage;
    }
    public void setPoliticalFace(String politicalFace) 
    {
        this.politicalFace = politicalFace;
    }

    public String getPoliticalFace() 
    {
        return politicalFace;
    }
    public void setIsBlacklist(String isBlacklist) 
    {
        this.isBlacklist = isBlacklist;
    }

    public String getIsBlacklist() 
    {
        return isBlacklist;
    }
    public void setRfm(String rfm) 
    {
        this.rfm = rfm;
    }

    public String getRfm() 
    {
        return rfm;
    }
    public void setRfe(String rfe) 
    {
        this.rfe = rfe;
    }

    public String getRfe() 
    {
        return rfe;
    }
    public void setPsm(String psm) 
    {
        this.psm = psm;
    }

    public String getPsm() 
    {
        return psm;
    }
    public void setUsg(String usg) 
    {
        this.usg = usg;
    }

    public String getUsg() 
    {
        return usg;
    }
    public void setAgeRange(String ageRange) 
    {
        this.ageRange = ageRange;
    }

    public String getAgeRange() 
    {
        return ageRange;
    }
    public void setBuyFrequency(String buyFrequency) 
    {
        this.buyFrequency = buyFrequency;
    }

    public String getBuyFrequency() 
    {
        return buyFrequency;
    }
    public void setConsumptionCycle(String consumptionCycle) 
    {
        this.consumptionCycle = consumptionCycle;
    }

    public String getConsumptionCycle() 
    {
        return consumptionCycle;
    }
    public void setExchangeRate(String exchangeRate) 
    {
        this.exchangeRate = exchangeRate;
    }

    public String getExchangeRate() 
    {
        return exchangeRate;
    }
    public void setLoginCycle(String loginCycle) 
    {
        this.loginCycle = loginCycle;
    }

    public String getLoginCycle() 
    {
        return loginCycle;
    }
    public void setLogFrequency(String logFrequency) 
    {
        this.logFrequency = logFrequency;
    }

    public String getLogFrequency() 
    {
        return logFrequency;
    }
    public void setLogTimeSlot(String logTimeSlot) 
    {
        this.logTimeSlot = logTimeSlot;
    }

    public String getLogTimeSlot() 
    {
        return logTimeSlot;
    }
    public void setMaxOrderRange(String maxOrderRange) 
    {
        this.maxOrderRange = maxOrderRange;
    }

    public String getMaxOrderRange() 
    {
        return maxOrderRange;
    }
    public void setPayType(String payType) 
    {
        this.payType = payType;
    }

    public String getPayType() 
    {
        return payType;
    }
    public void setReturnRate(String returnRate) 
    {
        this.returnRate = returnRate;
    }

    public String getReturnRate() 
    {
        return returnRate;
    }
    public void setUnitPriceRange(String unitPriceRange) 
    {
        this.unitPriceRange = unitPriceRange;
    }

    public String getUnitPriceRange() 
    {
        return unitPriceRange;
    }
    public void setBpTop1(String BpTop1) 
    {
        this.BpTop1 = BpTop1;
    }

    public String getBpTop1() 
    {
        return BpTop1;
    }
    public void setBpTop2(String BpTop2) 
    {
        this.BpTop2 = BpTop2;
    }

    public String getBpTop2() 
    {
        return BpTop2;
    }
    public void setBpTop3(String BpTop3) 
    {
        this.BpTop3 = BpTop3;
    }

    public String getBpTop3() 
    {
        return BpTop3;
    }
    public void setBpTop4(String BpTop4) 
    {
        this.BpTop4 = BpTop4;
    }

    public String getBpTop4() 
    {
        return BpTop4;
    }
    public void setBpTop5(String BpTop5) 
    {
        this.BpTop5 = BpTop5;
    }

    public String getBpTop5() 
    {
        return BpTop5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("gender", getGender())
            .append("job", getJob())
            .append("nationality", getNationality())
            .append("marriage", getMarriage())
            .append("politicalFace", getPoliticalFace())
            .append("isBlacklist", getIsBlacklist())
            .append("rfm", getRfm())
            .append("rfe", getRfe())
            .append("psm", getPsm())
            .append("usg", getUsg())
            .append("ageRange", getAgeRange())
            .append("buyFrequency", getBuyFrequency())
            .append("consumptionCycle", getConsumptionCycle())
            .append("exchangeRate", getExchangeRate())
            .append("loginCycle", getLoginCycle())
            .append("logFrequency", getLogFrequency())
            .append("logTimeSlot", getLogTimeSlot())
            .append("maxOrderRange", getMaxOrderRange())
            .append("payType", getPayType())
            .append("returnRate", getReturnRate())
            .append("unitPriceRange", getUnitPriceRange())
            .append("BpTop1", getBpTop1())
            .append("BpTop2", getBpTop2())
            .append("BpTop3", getBpTop3())
            .append("BpTop4", getBpTop4())
            .append("BpTop5", getBpTop5())
            .toString();
    }
}
