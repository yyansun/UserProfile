package com.ruoyi.tags.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tags.mapper.TblUsersConsumeMapper;
import com.ruoyi.tags.domain.TblUsersConsume;
import com.ruoyi.tags.service.ITblUsersConsumeService;

/**
 * 消费特征Service业务层处理
 * 
 * @author uus
 * @date 2024-03-15
 */
@Service
public class TblUsersConsumeServiceImpl implements ITblUsersConsumeService 
{
    @Autowired
    private TblUsersConsumeMapper tblUsersConsumeMapper;

    /**
     * 查询消费特征
     * 
     * @param id 消费特征主键
     * @return 消费特征
     */
    @Override
    public TblUsersConsume selectTblUsersConsumeById(Integer id)
    {
        return tblUsersConsumeMapper.selectTblUsersConsumeById(id);
    }

    /**
     * 查询消费特征列表
     * 
     * @param tblUsersConsume 消费特征
     * @return 消费特征
     */
    @Override
    public List<TblUsersConsume> selectTblUsersConsumeList(TblUsersConsume tblUsersConsume)
    {
        return tblUsersConsumeMapper.selectTblUsersConsumeList(tblUsersConsume);
    }

    /**
     * 新增消费特征
     * 
     * @param tblUsersConsume 消费特征
     * @return 结果
     */
    @Override
    public int insertTblUsersConsume(TblUsersConsume tblUsersConsume)
    {
        return tblUsersConsumeMapper.insertTblUsersConsume(tblUsersConsume);
    }

    /**
     * 修改消费特征
     * 
     * @param tblUsersConsume 消费特征
     * @return 结果
     */
    @Override
    public int updateTblUsersConsume(TblUsersConsume tblUsersConsume)
    {
        return tblUsersConsumeMapper.updateTblUsersConsume(tblUsersConsume);
    }

    /**
     * 批量删除消费特征
     * 
     * @param ids 需要删除的消费特征主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersConsumeByIds(Integer[] ids)
    {
        return tblUsersConsumeMapper.deleteTblUsersConsumeByIds(ids);
    }

    /**
     * 删除消费特征信息
     * 
     * @param id 消费特征主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersConsumeById(Integer id)
    {
        return tblUsersConsumeMapper.deleteTblUsersConsumeById(id);
    }
}
