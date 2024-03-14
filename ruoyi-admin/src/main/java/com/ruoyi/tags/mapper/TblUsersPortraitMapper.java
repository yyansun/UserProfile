package com.ruoyi.tags.mapper;

import java.util.List;
import com.ruoyi.tags.domain.TblUsersPortrait;

/**
 * 用户特征Mapper接口
 * 
 * @author uus
 * @date 2024-03-13
 */
public interface TblUsersPortraitMapper 
{
    /**
     * 查询用户特征
     * 
     * @param id 用户特征主键
     * @return 用户特征
     */
    public TblUsersPortrait selectTblUsersPortraitById(Integer id);

    /**
     * 查询用户特征列表
     * 
     * @param tblUsersPortrait 用户特征
     * @return 用户特征集合
     */
    public List<TblUsersPortrait> selectTblUsersPortraitList(TblUsersPortrait tblUsersPortrait);

    /**
     * 查询用户性别占比
     */
    public List<Integer> findByGender( );
    public List<Integer> findByPoliticalFace( );
    public List<Integer> findByJob( );
    public List<Integer> findByMarriage( );
    public List<Integer> findByRegion( );
    public List<Integer> findByAgeRange( );


    /**
     * 新增用户特征
     * 
     * @param tblUsersPortrait 用户特征
     * @return 结果
     */
    public int insertTblUsersPortrait(TblUsersPortrait tblUsersPortrait);

    /**
     * 修改用户特征
     * 
     * @param tblUsersPortrait 用户特征
     * @return 结果
     */
    public int updateTblUsersPortrait(TblUsersPortrait tblUsersPortrait);

    /**
     * 删除用户特征
     * 
     * @param id 用户特征主键
     * @return 结果
     */
    public int deleteTblUsersPortraitById(Integer id);

    /**
     * 批量删除用户特征
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblUsersPortraitByIds(Integer[] ids);
}
