package com.ruoyi.tags.service;

import java.util.List;
import com.ruoyi.tags.domain.TblUsersPortrait;

/**
 * 用户特征Service接口
 * 
 * @author uus
 * @date 2024-03-13
 */
public interface ITblUsersPortraitService 
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

    public List<Integer> findByGender();
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
     * 批量删除用户特征
     * 
     * @param ids 需要删除的用户特征主键集合
     * @return 结果
     */
    public int deleteTblUsersPortraitByIds(Integer[] ids);

    /**
     * 删除用户特征信息
     * 
     * @param id 用户特征主键
     * @return 结果
     */
    public int deleteTblUsersPortraitById(Integer id);
}
