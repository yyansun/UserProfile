package com.ruoyi.tags.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tags.mapper.TblUsersPreferenceMapper;
import com.ruoyi.tags.domain.TblUsersPreference;
import com.ruoyi.tags.service.ITblUsersPreferenceService;

/**
 * 兴趣特征1Service业务层处理
 * 
 * @author uus
 * @date 2024-03-16
 */
@Service
public class TblUsersPreferenceServiceImpl implements ITblUsersPreferenceService 
{
    @Autowired
    private TblUsersPreferenceMapper tblUsersPreferenceMapper;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TblUsersPreferenceServiceImpl.class);

    /**
     * 查询兴趣特征1
     * 
     * @param id 兴趣特征1主键
     * @return 兴趣特征1
     */
    @Override
    public TblUsersPreference selectTblUsersPreferenceById(Integer id)
    {
        return tblUsersPreferenceMapper.selectTblUsersPreferenceById(id);
    }

    @Override
    public List<Integer> findByLoginCycle() {
        logger.debug("Entering findByLoginCycle......");

        List<Integer> res = tblUsersPreferenceMapper.findByLoginCycle();
        logger.debug("LoginCycle data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findByFrequency() {
        logger.debug("Entering findByFrequency......");

        List<Integer> res = tblUsersPreferenceMapper.findByFrequency();
        logger.debug("Frequency data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findByUsg() {
        logger.debug("Entering findByUsg......");

        List<Integer> res = tblUsersPreferenceMapper.findByUsg();
        logger.debug("Usg data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findByRfe() {
        logger.debug("Entering findByRfe......");

        List<Integer> res = tblUsersPreferenceMapper.findByRfe();
        logger.debug("Rfe data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findByFreqValue() {
        logger.debug("Entering findByFreqValue .....");

        List<Integer> res = tblUsersPreferenceMapper.findByFreqValue();
        logger.debug("FreqValue data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findByTimeSlot() {
        logger.debug("Entering findByTimeSlot......");

        List<Integer> res = tblUsersPreferenceMapper.findByTimeSlot();
        logger.debug("TimeSlot data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findBytop1() {
        logger.debug("Entering findByTop1......");

        List <Integer> res = tblUsersPreferenceMapper.findByTop1();
        logger.debug("Top1 data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findBytop2() {
        logger.debug("Entering findByTop2......");

        List<Integer> res = tblUsersPreferenceMapper.findByTop2();
        logger.debug("Top2 data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findBytop3() {
        logger.debug("Entering findByTop3......");

        List<Integer> res = tblUsersPreferenceMapper.findByTop3();
        logger.debug("Top3 data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findBytop4() {
        logger.debug("Entering findByTop4......");

        List<Integer> res = tblUsersPreferenceMapper.findByTop4();
        logger.debug("Top4 data : {}", res);

        return res;
    }

    @Override
    public List<Integer> findBytop5() {
        logger.debug("Entering findByTop5......");

        List<Integer> res = tblUsersPreferenceMapper.findByTop5();
        logger.debug("Top5 data : {}", res);

        return res;
    }


    /**
     * 查询兴趣特征1列表
     * 
     * @param tblUsersPreference 兴趣特征1
     * @return 兴趣特征1
     */
    @Override
    public List<TblUsersPreference> selectTblUsersPreferenceList(TblUsersPreference tblUsersPreference)
    {
        return tblUsersPreferenceMapper.selectTblUsersPreferenceList(tblUsersPreference);
    }

    /**
     * 新增兴趣特征1
     * 
     * @param tblUsersPreference 兴趣特征1
     * @return 结果
     */
    @Override
    public int insertTblUsersPreference(TblUsersPreference tblUsersPreference)
    {
        return tblUsersPreferenceMapper.insertTblUsersPreference(tblUsersPreference);
    }

    /**
     * 修改兴趣特征1
     * 
     * @param tblUsersPreference 兴趣特征1
     * @return 结果
     */
    @Override
    public int updateTblUsersPreference(TblUsersPreference tblUsersPreference)
    {
        return tblUsersPreferenceMapper.updateTblUsersPreference(tblUsersPreference);
    }

    /**
     * 批量删除兴趣特征1
     * 
     * @param ids 需要删除的兴趣特征1主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersPreferenceByIds(Integer[] ids)
    {
        return tblUsersPreferenceMapper.deleteTblUsersPreferenceByIds(ids);
    }

    /**
     * 删除兴趣特征1信息
     * 
     * @param id 兴趣特征1主键
     * @return 结果
     */
    @Override
    public int deleteTblUsersPreferenceById(Integer id)
    {
        return tblUsersPreferenceMapper.deleteTblUsersPreferenceById(id);
    }
}
