package com.ruoyi.tags.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tags.mapper.TblUsersPreferenceMapper;
import com.ruoyi.tags.domain.TblUsersPreference;
import com.ruoyi.tags.service.ITblUsersPreferenceService;

/**
 * 兴趣特征Service业务层处理
 * 
 * @author uus
 * @date 2024-03-15
 */
@Service
public class TblUsersPreferenceServiceImpl implements ITblUsersPreferenceService 
{
    @Autowired
    private TblUsersPreferenceMapper tblUsersPreferenceMapper;

    /**
     * 查询兴趣特征
     * 
     * @param id 兴趣特征主键
     * @return 兴趣特征
     */
    @Override
    public TblUsersPreference selectTblUsersPreferenceById(Integer id)
    {
        return tblUsersPreferenceMapper.selectTblUsersPreferenceById(id);
    }

    /**
     * 查询兴趣特征列表
     * 
     * @param tblUsersPreference 兴趣特征
     * @return 兴趣特征
     */
    @Override
    public List<TblUsersPreference> selectTblUsersPreferenceList(TblUsersPreference tblUsersPreference)
    {
        return tblUsersPreferenceMapper.selectTblUsersPreferenceList(tblUsersPreference);
    }

    /**
     * 新增兴趣特征
     * 
     * @param tblUsersPreference 兴趣特征
     * @return 结果
     */
    @Override
    public int insertTblUsersPreference(TblUsersPreference tblUsersPreference)
    {
        return tblUsersPreferenceMapper.insertTblUsersPreference(tblUsersPreference);
    }

    /**
     * 修改兴趣特征
     * 
     * @param tblUsersPreference 兴趣特征
     * @return 结果
     */
    @Override
    public int updateTblUsersPreference(TblUsersPreference tblUsersPreference)
    {
        return tblUsersPreferenceMapper.updateTblUsersPreference(tblUsersPreference);
    }

    /**
     * 批量删除兴趣特征
     * 
     * @param ids 需要删除的兴趣特征主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersPreferenceByIds(Integer[] ids)
    {
        return tblUsersPreferenceMapper.deleteTblUsersPreferenceByIds(ids);
    }

    /**
     * 删除兴趣特征信息
     * 
     * @param id 兴趣特征主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersPreferenceById(Integer id)
    {
        return tblUsersPreferenceMapper.deleteTblUsersPreferenceById(id);
    }
}
