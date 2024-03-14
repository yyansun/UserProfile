package com.ruoyi.tags.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tags.mapper.TblUsersPortraitMapper;
import com.ruoyi.tags.domain.TblUsersPortrait;
import com.ruoyi.tags.service.ITblUsersPortraitService;

/**
 * 用户特征Service业务层处理
 * 
 * @author uus
 * @date 2024-03-13
 */
@Service
public class TblUsersPortraitServiceImpl implements ITblUsersPortraitService 
{
    @Autowired
    private TblUsersPortraitMapper tblUsersPortraitMapper;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(TblUsersPortraitServiceImpl.class);

    /**
     * 查询用户特征
     * 
     * @param id 用户特征主键
     * @return 用户特征
     */
    @Override
    public TblUsersPortrait selectTblUsersPortraitById(Integer id)
    {
        return tblUsersPortraitMapper.selectTblUsersPortraitById(id);
    }

    @Override
    public List<Integer> findByGender()
    {
        logger.debug("Entering findByGender......");

        List<Integer> res = tblUsersPortraitMapper.findByGender();
        logger.debug("Gender data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findByPoliticalFace()
    {
        logger.debug("Entering findByPoliticalFace......");

        List<Integer> res = tblUsersPortraitMapper.findByPoliticalFace();
        logger.debug("PoliticalFace data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findByMarriage()
    {
        logger.debug("Entering findByMarriage......");

        List<Integer> res = tblUsersPortraitMapper.findByMarriage();
        logger.debug("Marriage data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findByRegion()
    {
        logger.debug("Entering findByRegion......");

        List<Integer> res = tblUsersPortraitMapper.findByRegion();
        logger.debug("GRegion data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findByAgeRange()
    {
        logger.debug("Entering fAgeRange......");

        List<Integer> res = tblUsersPortraitMapper.findByAgeRange();
        logger.debug("AgeRange data : {}", res);

        return res;
    }
    @Override
    public List<Integer> findByJob()
    {
        logger.debug("Entering findByJob......");

        List<Integer> res = tblUsersPortraitMapper.findByJob();
        logger.debug("Job data : {}", res);

        return res;
    }

    /**
     * 查询用户特征列表
     * 
     * @param tblUsersPortrait 用户特征
     * @return 用户特征
     */
    @Override
    public List<TblUsersPortrait> selectTblUsersPortraitList(TblUsersPortrait tblUsersPortrait)
    {
        return tblUsersPortraitMapper.selectTblUsersPortraitList(tblUsersPortrait);
    }


    /**
     * 新增用户特征
     * 
     * @param tblUsersPortrait 用户特征
     * @return 结果
     */
    @Override
    public int insertTblUsersPortrait(TblUsersPortrait tblUsersPortrait)
    {
        return tblUsersPortraitMapper.insertTblUsersPortrait(tblUsersPortrait);
    }

    /**
     * 修改用户特征
     * 
     * @param tblUsersPortrait 用户特征
     * @return 结果
     */
    @Override
    public int updateTblUsersPortrait(TblUsersPortrait tblUsersPortrait)
    {
        return tblUsersPortraitMapper.updateTblUsersPortrait(tblUsersPortrait);
    }

    /**
     * 批量删除用户特征
     * 
     * @param ids 需要删除的用户特征主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersPortraitByIds(Integer[] ids)
    {
        return tblUsersPortraitMapper.deleteTblUsersPortraitByIds(ids);
    }

    /**
     * 删除用户特征信息
     * 
     * @param id 用户特征主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersPortraitById(Integer id)
    {
        return tblUsersPortraitMapper.deleteTblUsersPortraitById(id);
    }
}
