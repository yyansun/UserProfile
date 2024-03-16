package com.ruoyi.tags.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tags.mapper.TblUsersGrouptagMapper;
import com.ruoyi.tags.domain.TblUsersGrouptag;
import com.ruoyi.tags.service.ITblUsersGrouptagService;

/**
 * 组合标签Service业务层处理
 * 
 * @author uus
 * @date 2024-03-16
 */
@Service
public class TblUsersGrouptagServiceImpl implements ITblUsersGrouptagService 
{
    @Autowired
    private TblUsersGrouptagMapper tblUsersGrouptagMapper;

    /**
     * 查询组合标签
     * 
     * @param id 组合标签主键
     * @return 组合标签
     */
    @Override
    public TblUsersGrouptag selectTblUsersGrouptagById(Integer id)
    {
        return tblUsersGrouptagMapper.selectTblUsersGrouptagById(id);
    }

    /**
     * 查询组合标签列表
     * 
     * @param tblUsersGrouptag 组合标签
     * @return 组合标签
     */
    @Override
    public List<TblUsersGrouptag> selectTblUsersGrouptagList(TblUsersGrouptag tblUsersGrouptag)
    {
        return tblUsersGrouptagMapper.selectTblUsersGrouptagList(tblUsersGrouptag);
    }

    /**
     * 新增组合标签
     * 
     * @param tblUsersGrouptag 组合标签
     * @return 结果
     */
    @Override
    public int insertTblUsersGrouptag(TblUsersGrouptag tblUsersGrouptag)
    {
        return tblUsersGrouptagMapper.insertTblUsersGrouptag(tblUsersGrouptag);
    }

    /**
     * 修改组合标签
     * 
     * @param tblUsersGrouptag 组合标签
     * @return 结果
     */
    @Override
    public int updateTblUsersGrouptag(TblUsersGrouptag tblUsersGrouptag)
    {
        return tblUsersGrouptagMapper.updateTblUsersGrouptag(tblUsersGrouptag);
    }

    /**
     * 批量删除组合标签
     * 
     * @param ids 需要删除的组合标签主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersGrouptagByIds(Integer[] ids)
    {
        return tblUsersGrouptagMapper.deleteTblUsersGrouptagByIds(ids);
    }

    /**
     * 删除组合标签信息
     * 
     * @param id 组合标签主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersGrouptagById(Integer id)
    {
        return tblUsersGrouptagMapper.deleteTblUsersGrouptagById(id);
    }
}
