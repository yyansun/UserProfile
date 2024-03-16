package com.ruoyi.tags.service;

import java.util.List;
import com.ruoyi.tags.domain.TblUsersPreference;

/**
 * 兴趣特征1Service接口
 * 
 * @author uus
 * @date 2024-03-16
 */
public interface ITblUsersPreferenceService 
{
    /**
     * 查询兴趣特征1
     * 
     * @param id 兴趣特征1主键
     * @return 兴趣特征1
     */
    public TblUsersPreference selectTblUsersPreferenceById(Integer id);

    /**
     * 查询兴趣特征1列表
     * 
     * @param tblUsersPreference 兴趣特征1
     * @return 兴趣特征1集合
     */
    public List<TblUsersPreference> selectTblUsersPreferenceList(TblUsersPreference tblUsersPreference);

    public List<Integer> findByLoginCycle();

    public List<Integer> findByFrequency();

    public List<Integer> findByUsg();

    public List<Integer> findByRfe();

    public List<Integer> findByFreqValue();

    public List<Integer> findByTimeSlot();

    public List<Integer> findBytop1();

    public List<Integer> findBytop2();

    public List<Integer> findBytop3();

    public List<Integer> findBytop4();

    public List<Integer> findBytop5();


    /**
     * 新增兴趣特征1
     * 
     * @param tblUsersPreference 兴趣特征1
     * @return 结果
     */
    public int insertTblUsersPreference(TblUsersPreference tblUsersPreference);

    /**
     * 修改兴趣特征1
     * 
     * @param tblUsersPreference 兴趣特征1
     * @return 结果
     */
    public int updateTblUsersPreference(TblUsersPreference tblUsersPreference);

    /**
     * 批量删除兴趣特征1
     * 
     * @param ids 需要删除的兴趣特征1主键集合
     * @return 结果
     */
    public int deleteTblUsersPreferenceByIds(Integer[] ids);

    /**
     * 删除兴趣特征1信息
     * 
     * @param id 兴趣特征1主键
     * @return 结果
     */
    public int deleteTblUsersPreferenceById(Integer id);
}
