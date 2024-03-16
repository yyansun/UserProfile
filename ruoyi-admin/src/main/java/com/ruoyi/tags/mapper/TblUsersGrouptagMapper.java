package com.ruoyi.tags.mapper;

import java.util.List;
import com.ruoyi.tags.domain.TblUsersGrouptag;

/**
 * 组合标签Mapper接口
 * 
 * @author uus
 * @date 2024-03-16
 */
public interface TblUsersGrouptagMapper 
{
    /**
     * 查询组合标签
     * 
     * @param id 组合标签主键
     * @return 组合标签
     */
    public TblUsersGrouptag selectTblUsersGrouptagById(Integer id);

    /**
     * 查询组合标签列表
     * 
     * @param tblUsersGrouptag 组合标签
     * @return 组合标签集合
     */
    public List<TblUsersGrouptag> selectTblUsersGrouptagList(TblUsersGrouptag tblUsersGrouptag);

    /**
     * 新增组合标签
     * 
     * @param tblUsersGrouptag 组合标签
     * @return 结果
     */
    public int insertTblUsersGrouptag(TblUsersGrouptag tblUsersGrouptag);

    /**
     * 修改组合标签
     * 
     * @param tblUsersGrouptag 组合标签
     * @return 结果
     */
    public int updateTblUsersGrouptag(TblUsersGrouptag tblUsersGrouptag);

    /**
     * 删除组合标签
     * 
     * @param id 组合标签主键
     * @return 结果
     */
    public int deleteTblUsersGrouptagById(Integer id);

    /**
     * 批量删除组合标签
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblUsersGrouptagByIds(Integer[] ids);
}
