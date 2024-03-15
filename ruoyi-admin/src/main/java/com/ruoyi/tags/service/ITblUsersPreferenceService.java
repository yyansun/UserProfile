package com.ruoyi.tags.service;

import java.util.List;
import com.ruoyi.tags.domain.TblUsersPreference;

/**
 * 兴趣特征Service接口
 * 
 * @author uus
 * @date 2024-03-15
 */
public interface ITblUsersPreferenceService 
{
    /**
     * 查询兴趣特征
     * 
     * @param id 兴趣特征主键
     * @return 兴趣特征
     */
    public TblUsersPreference selectTblUsersPreferenceById(Integer id);

    /**
     * 查询兴趣特征列表
     * 
     * @param tblUsersPreference 兴趣特征
     * @return 兴趣特征集合
     */
    public List<TblUsersPreference> selectTblUsersPreferenceList(TblUsersPreference tblUsersPreference);

    /**
     * 新增兴趣特征
     * 
     * @param tblUsersPreference 兴趣特征
     * @return 结果
     */
    public int insertTblUsersPreference(TblUsersPreference tblUsersPreference);

    /**
     * 修改兴趣特征
     * 
     * @param tblUsersPreference 兴趣特征
     * @return 结果
     */
    public int updateTblUsersPreference(TblUsersPreference tblUsersPreference);

    /**
     * 批量删除兴趣特征
     * 
     * @param ids 需要删除的兴趣特征主键集合
     * @return 结果
     */
    public int deleteTblUsersPreferenceByIds(Integer[] ids);

    /**
     * 删除兴趣特征信息
     * 
     * @param id 兴趣特征主键
     * @return 结果
     */
    public int deleteTblUsersPreferenceById(Integer id);
}
