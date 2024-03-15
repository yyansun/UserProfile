package com.ruoyi.tags.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消费特征对象 tbl_users_consume
 * 
 * @author uus
 * @date 2024-03-15
 */
public class TblUsersConsume extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 黑名单 */
    @Excel(name = "黑名单")
    private Integer isBlacklist;

    /** 消费周期 */
    @Excel(name = "消费周期")
    private String consumptionCycle;

    /** 客单价 */
    @Excel(name = "客单价")
    private Long unitPrice;

    /** 客单价 */
    private Integer unitPriceRange;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private Integer payment;

    /** 单笔最高 */
    @Excel(name = "单笔最高")
    private Long maxOrderAmount;

    /** 单笔最高 */
    private Integer maxOrderRange;

    /** 购买次数/月 */
    @Excel(name = "购买次数/月")
    private Long frequency;

    /** 购买频率 */
    private Integer freqValue;

    /** 退货次数/月 */
    @Excel(name = "退货次数/月")
    private Integer returnRate;

    /** 退货频率 */
    private Integer retValue;

    /** 换货次数/月 */
    @Excel(name = "换货次数/月")
    private Integer exchangeRate;

    /** 换货频率 */
    private Integer excValue;

    /** 消费能力 */
    @Excel(name = "消费能力")
    private Integer rfm;

    /** 价格敏感度 */
    @Excel(name = "价格敏感度")
    private Integer psm;

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
    public void setIsBlacklist(Integer isBlacklist) 
    {
        this.isBlacklist = isBlacklist;
    }

    public Integer getIsBlacklist() 
    {
        return isBlacklist;
    }
    public void setConsumptionCycle(String consumptionCycle) 
    {
        this.consumptionCycle = consumptionCycle;
    }

    public String getConsumptionCycle() 
    {
        return consumptionCycle;
    }
    public void setUnitPrice(Long unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public Long getUnitPrice() 
    {
        return unitPrice;
    }
    public void setUnitPriceRange(Integer unitPriceRange) 
    {
        this.unitPriceRange = unitPriceRange;
    }

    public Integer getUnitPriceRange() 
    {
        return unitPriceRange;
    }
    public void setPayment(Integer payment) 
    {
        this.payment = payment;
    }

    public Integer getPayment() 
    {
        return payment;
    }
    public void setMaxOrderAmount(Long maxOrderAmount) 
    {
        this.maxOrderAmount = maxOrderAmount;
    }

    public Long getMaxOrderAmount() 
    {
        return maxOrderAmount;
    }
    public void setMaxOrderRange(Integer maxOrderRange) 
    {
        this.maxOrderRange = maxOrderRange;
    }

    public Integer getMaxOrderRange() 
    {
        return maxOrderRange;
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
    public void setReturnRate(Integer returnRate) 
    {
        this.returnRate = returnRate;
    }

    public Integer getReturnRate() 
    {
        return returnRate;
    }
    public void setRetValue(Integer retValue) 
    {
        this.retValue = retValue;
    }

    public Integer getRetValue() 
    {
        return retValue;
    }
    public void setExchangeRate(Integer exchangeRate) 
    {
        this.exchangeRate = exchangeRate;
    }

    public Integer getExchangeRate() 
    {
        return exchangeRate;
    }
    public void setExcValue(Integer excValue) 
    {
        this.excValue = excValue;
    }

    public Integer getExcValue() 
    {
        return excValue;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("isBlacklist", getIsBlacklist())
            .append("consumptionCycle", getConsumptionCycle())
            .append("unitPrice", getUnitPrice())
            .append("unitPriceRange", getUnitPriceRange())
            .append("payment", getPayment())
            .append("maxOrderAmount", getMaxOrderAmount())
            .append("maxOrderRange", getMaxOrderRange())
            .append("frequency", getFrequency())
            .append("freqValue", getFreqValue())
            .append("returnRate", getReturnRate())
            .append("retValue", getRetValue())
            .append("exchangeRate", getExchangeRate())
            .append("excValue", getExcValue())
            .append("rfm", getRfm())
            .append("psm", getPsm())
            .toString();
    }
}
