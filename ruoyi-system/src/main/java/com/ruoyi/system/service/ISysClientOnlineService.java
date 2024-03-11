package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.model.ClientUser;
import com.ruoyi.system.domain.SysClientOnline;

/**
条件查询客户信息 服务层
 
 **/
public interface ISysClientOnlineService {
    /**
     * 通过性别查询信息
     *
     * @param gender 性别
     * @param client 客户信息
     * @return 满足条件的客户信息
     */
    public SysClientOnline selectOnlineByGender(String gender, ClientUser client);

    /**
     * 通过年龄（生日）查询信息
     *
     * @param birthday 生日
     * @param client 客户信息
     * @return 满足条件的客户信息
     */
    public SysClientOnline selectOnlineByBirthday(String birthday, ClientUser client);

    /**
     * 通过职业查询信息
     *
     * @param job 职业
     * @param client 客户信息
     * @return 满足条件的客户信息
     */
    public SysClientOnline selectOnlineByJob(String job, ClientUser client);

    /**
     * 通过政治面貌查询信息
     *
     * @param politicalFace 政治面貌
     * @param client 客户信息
     * @return 满足条件的客户信息
     */
    public SysClientOnline selectOnlineByPoliticalFace(String politicalFace, ClientUser client);

    /**
     * 通过婚姻状况查询信息
     *
     * @param marriage 婚姻状况
     * @param client 客户信息
     * @return 满足条件的客户信息
     */
    public SysClientOnline selectOnlineByMarriage(String marriage, ClientUser client);

    /**
     * 通过所属地区查询信息
     *
     * @param region 地区
     * @param client 客户信息
     * @return 满足条件的客户信息
     */
    public SysClientOnline selectOnlineByRegion(String region, ClientUser client);

    /**
     * 设置满足条件的客户信息
     *
     * @param client 客户信息
     * @return 客户信息
     */
    public SysClientOnline ClientUserToClientOnline(ClientUser client);
}
