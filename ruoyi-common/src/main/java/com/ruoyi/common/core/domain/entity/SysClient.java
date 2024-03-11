package com.ruoyi.common.core.domain.entity;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.xss.Xss;

/**
 * 电商客户 sys_client
 *
 * @author becky
 */
public class SysClient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户ID */
    @Excel(name = "序号", cellType = ColumnType.NUMERIC, prompt = "编号")
    private Integer id;

//    /** 部门ID */
//    @Excel(name = "部门编号", type = Type.IMPORT)
//    private Long deptId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String username;

//    /** 客户昵称 */
//    @Excel(name = "客户名称")
//    private String nickName;
//
//    /** 客户邮箱 */
//    @Excel(name = "客户邮箱")
//    private String email;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String mobile;

    /** 性别 */
    @Excel(name = "性别", readConverterExp = "0=保密,1=男,2=女")
    private String gender;

    /** 生日 */
    @Excel(name = "生日", dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 职业 */
    @Excel(name = "职业", readConverterExp = "1=学生,2=公务员,3=军人,4=警察,5=教师,6=白领")
    private String job;

    /** 政治面貌 */
    @Excel(name = "政治面貌", readConverterExp = "1=群众,2=党员,3=无党派人士")
    private String politicalFace;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况", readConverterExp = "1=未婚,2=已婚,3=离异")
    private String marriage;

    /** 所属地区 */
    @Excel(name = "所属地区", readConverterExp = "1=中国大陆,2=中国香港,3=中国澳门,4=中国台湾")
    private String region;

//    /** 客户头像 */
//    private String avatar;
//
//    /** 密码 */
//    private String password;
//
//    /** 帐号状态（0正常 1停用） */
//    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
//    private String status;
//
//    /** 删除标志（0代表存在 2代表删除） */
//    private String delFlag;
//
//    /** 最后登录IP */
//    @Excel(name = "最后登录IP", type = Type.EXPORT)
//    private String loginIp;
//
//    /** 最后登录时间 */
//    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
//    private Date loginDate;

//    /** 部门对象 */
//    @Excels({
//            @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT),
//            @Excel(name = "部门负责人", targetAttr = "leader", type = Type.EXPORT)
//    })
//    private SysDept dept;
//
//    /** 角色对象 */
//    private List<SysRole> roles;
//
//    /** 角色组 */
//    private Long[] roleIds;
//
//    /** 岗位组 */
//    private Long[] postIds;
//
//    /** 角色ID */
//    private Long roleId;

    public SysClient()
    {

    }

    public SysClient(Integer id)
    {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPoliticalFace() {
        return politicalFace;
    }

    public void setPoliticalFace(String politicalFace) {
        this.politicalFace = politicalFace;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("username", getUsername())
                .append("gender", getGender())
                .append("birthday", getBirthday())
                .append("job", getJob())
                .append("politicalFace", getPoliticalFace())
                .append("region", getRegion())
                .append("marriage", getMarriage())
                .append("mobile", getMobile())
                .toString();
    }
}
