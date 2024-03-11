package com.ruoyi.common.core.domain.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.ruoyi.common.core.domain.entity.SysClient;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;

/**
 * 客户信息
 *
 * @author becky
 */
public class ClientUser implements UserDetails
{
    private static final long serialVersionUID = 1L;

    /**
     * 客户ID
     */
    private Integer id;
    private String username;
    private Integer gender;
    private String birthday;
    private Integer job;
    private Integer politicalFace;
    private Integer marriage;
    private Integer region;
    private String mobile;


    /**
     * 客户信息
     */
    private SysClient client;

    public ClientUser()
    {
    }

    public ClientUser(SysClient client, Integer id, String username)
    {
        this.client = client;
//        this.permissions = permissions;
        this.id = id;
        this.username = username;

    }

//    public ClientUser(Long userId, Long deptId, SysUser user, Set<String> permissions)
//    {
//        this.userId = userId;
//        this.deptId = deptId;
//        this.user = user;
//        this.permissions = permissions;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public SysClient getClient() {
        return client;
    }

    public void setClient(SysClient client) {
        this.client = client;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
