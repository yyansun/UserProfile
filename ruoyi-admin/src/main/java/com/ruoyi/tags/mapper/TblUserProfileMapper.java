package com.ruoyi.tags.mapper;

import java.util.List;
import com.ruoyi.tags.domain.TblUserProfile;

/**
 * 单人画像Mapper接口
 * 
 * @author uus
 * @date 2024-03-16
 */
public interface TblUserProfileMapper 
{
    /**
     * 查询单人画像
     * 
     * @param userId 单人画像主键
     * @return 单人画像
     */
    public TblUserProfile selectTblUserProfileByUserId(Long userId);

    /**
     * 查询单人画像列表
     * 
     * @param tblUserProfile 单人画像
     * @return 单人画像集合
     */
    public List<TblUserProfile> selectTblUserProfileList(TblUserProfile tblUserProfile);

    /**
     * 新增单人画像
     * 
     * @param tblUserProfile 单人画像
     * @return 结果
     */
    public int insertTblUserProfile(TblUserProfile tblUserProfile);

    /**
     * 修改单人画像
     * 
     * @param tblUserProfile 单人画像
     * @return 结果
     */
    public int updateTblUserProfile(TblUserProfile tblUserProfile);

    /**
     * 删除单人画像
     * 
     * @param userId 单人画像主键
     * @return 结果
     */
    public int deleteTblUserProfileByUserId(Long userId);

    /**
     * 批量删除单人画像
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblUserProfileByUserIds(Long[] userIds);
}
