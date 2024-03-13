package com.ruoyi.tags.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户特征对象 tbl_users_portrait
 * 
 * @author uus
 * @date 2024-03-13
 */
public class TblUsersPortrait extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 特殊会员等级id，0表示非特殊会员等级 */
    private Integer memberRankId;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 职业 */
    @Excel(name = "职业")
    private Integer job;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String mobile;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private Integer politicalFace;

    /** 所属地区 */
    @Excel(name = "所属地区")
    private Integer region;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private Integer marriage;

    /** 年龄段 */
    private String ageRange;

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
    public void setMemberRankId(Integer memberRankId) 
    {
        this.memberRankId = memberRankId;
    }

    public Integer getMemberRankId() 
    {
        return memberRankId;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setJob(Integer job) 
    {
        this.job = job;
    }

    public Integer getJob() 
    {
        return job;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setPoliticalFace(Integer politicalFace) 
    {
        this.politicalFace = politicalFace;
    }

    public Integer getPoliticalFace() 
    {
        return politicalFace;
    }
    public void setRegion(Integer region) 
    {
        this.region = region;
    }

    public Integer getRegion() 
    {
        return region;
    }
    public void setMarriage(Integer marriage) 
    {
        this.marriage = marriage;
    }

    public Integer getMarriage() 
    {
        return marriage;
    }
    public void setAgeRange(String ageRange) 
    {
        this.ageRange = ageRange;
    }

    public String getAgeRange() 
    {
        return ageRange;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("memberRankId", getMemberRankId())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("job", getJob())
            .append("mobile", getMobile())
            .append("politicalFace", getPoliticalFace())
            .append("region", getRegion())
            .append("marriage", getMarriage())
            .append("ageRange", getAgeRange())
            .toString();
    }
}
