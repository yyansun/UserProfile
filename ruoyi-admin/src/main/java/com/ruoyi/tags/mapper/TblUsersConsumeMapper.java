package com.ruoyi.tags.mapper;

import java.util.List;
import com.ruoyi.tags.domain.TblUsersConsume;

/**
 * 消费特征Mapper接口
 * 
 * @author uus
 * @date 2024-03-15
 */
public interface TblUsersConsumeMapper 
{
    /**
     * 查询消费特征
     * 
     * @param id 消费特征主键
     * @return 消费特征
     */
    public TblUsersConsume selectTblUsersConsumeById(Integer id);

    /**
     * 查询消费特征列表
     * 
     * @param tblUsersConsume 消费特征
     * @return 消费特征集合
     */
    public List<TblUsersConsume> selectTblUsersConsumeList(TblUsersConsume tblUsersConsume);

    /**
     * 新增消费特征
     * 
     * @param tblUsersConsume 消费特征
     * @return 结果
     */
    public int insertTblUsersConsume(TblUsersConsume tblUsersConsume);

    /**
     * 修改消费特征
     * 
     * @param tblUsersConsume 消费特征
     * @return 结果
     */
    public int updateTblUsersConsume(TblUsersConsume tblUsersConsume);

    /**
     * 删除消费特征
     * 
     * @param id 消费特征主键
     * @return 结果
     */
    public int deleteTblUsersConsumeById(Integer id);

    /**
     * 批量删除消费特征
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblUsersConsumeByIds(Integer[] ids);
}
