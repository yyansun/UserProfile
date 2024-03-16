package com.ruoyi.tags.mapper;

import java.util.List;
import com.ruoyi.tags.domain.TblUsersPreference;

/**
 * 兴趣特征1Mapper接口
 * 
 * @author uus
 * @date 2024-03-16
 */
public interface TblUsersPreferenceMapper 
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

    public List<Integer> findByLoginCycle( );
    public List<Integer> findByFreqValue( );
    public List<Integer> findByUsg( );
    public List<Integer> findByRfe( );
    public List<Integer> findByTimeSlot( );
    public List<Integer> findByFrequency( );
    public List<Integer> findByTop1( );
    public List<Integer> findByTop2( );
    public List<Integer> findByTop3( );
    public List<Integer> findByTop4( );
    public List<Integer> findByTop5( );

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
     * 删除兴趣特征1
     * 
     * @param id 兴趣特征1主键
     * @return 结果
     */
    public int deleteTblUsersPreferenceById(Integer id);

    /**
     * 批量删除兴趣特征1
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblUsersPreferenceByIds(Integer[] ids);
}
