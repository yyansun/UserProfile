package com.ruoyi.tags.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tags.mapper.TblUserProfileMapper;
import com.ruoyi.tags.domain.TblUserProfile;
import com.ruoyi.tags.service.ITblUserProfileService;

/**
 * 单人画像Service业务层处理
 * 
 * @author uus
 * @date 2024-03-16
 */
@Service
public class TblUserProfileServiceImpl implements ITblUserProfileService 
{
    @Autowired
    private TblUserProfileMapper tblUserProfileMapper;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TblUsersPortraitServiceImpl.class);

    /**
     * 查询单人画像
     * 
     * @param userId 单人画像主键
     * @return 单人画像
     */
    @Override
    public TblUserProfile selectTblUserProfileByUserId(Long userId)
    {
        logger.debug("#############根据ID查询单人用户画像===================");

        TblUserProfile res = tblUserProfileMapper.selectTblUserProfileByUserId(userId);
        logger.debug("tblUserProfile: {}", res);
//        return tblUserProfileMapper.selectTblUserProfileByUserId(userId);
        return res;
    }

    /**
     * 查询单人画像列表
     * 
     * @param tblUserProfile 单人画像
     * @return 单人画像
     */
    @Override
    public List<TblUserProfile> selectTblUserProfileList(TblUserProfile tblUserProfile)
    {
        return tblUserProfileMapper.selectTblUserProfileList(tblUserProfile);
    }

    /**
     * 新增单人画像
     * 
     * @param tblUserProfile 单人画像
     * @return 结果
     */
    @Override
    public int insertTblUserProfile(TblUserProfile tblUserProfile)
    {
        return tblUserProfileMapper.insertTblUserProfile(tblUserProfile);
    }

    /**
     * 修改单人画像
     * 
     * @param tblUserProfile 单人画像
     * @return 结果
     */
    @Override
    public int updateTblUserProfile(TblUserProfile tblUserProfile)
    {
        return tblUserProfileMapper.updateTblUserProfile(tblUserProfile);
    }

    /**
     * 批量删除单人画像
     * 
     * @param userIds 需要删除的单人画像主键
     * @return 结果
     */
    @Override
    public int deleteTblUserProfileByUserIds(Long[] userIds)
    {
        return tblUserProfileMapper.deleteTblUserProfileByUserIds(userIds);
    }

    /**
     * 删除单人画像信息
     * 
     * @param userId 单人画像主键
     * @return 结果
     */
    @Override
    public int deleteTblUserProfileByUserId(Long userId)
    {
        return tblUserProfileMapper.deleteTblUserProfileByUserId(userId);
    }
}
