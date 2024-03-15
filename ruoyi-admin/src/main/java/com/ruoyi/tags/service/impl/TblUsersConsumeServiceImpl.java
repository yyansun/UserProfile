package com.ruoyi.tags.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TblUsersConsumeServiceImpl.class);

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
     * =============查询各类别数量==============
     */
    public List<Integer> findIsBlackList()
    {
        logger.debug("#################Entering blacklist");

        List<Integer> res = tblUsersConsumeMapper.findIsBlackList();
        logger.debug("blacklist data: {}", res);

        return res;
    }
    public List<Integer> findConsumptionCycle(){
        logger.debug("#################Entering consumptionCycle");

        List<Integer> res = tblUsersConsumeMapper.findConsumptionCycle();
        logger.debug("consumptionCycle data: {}", res);

        return res;
    }
    public List<Integer> findUnitPrice()
    {
        logger.debug("#################Entering UnitPrice");

        List<Integer> res = tblUsersConsumeMapper.findUnitPrice();
        logger.debug("UnitPrice data: {}", res);

        return res;
    }
    public List<Integer> findUnitPriceRange()
    {
        logger.debug("#################Entering UnitPriceRange");

        List<Integer> res = tblUsersConsumeMapper.findUnitPriceRange();
        logger.debug("UnitPriceRange data: {}", res);

        return res;
    }
    public List<Integer> findPayment()
    {
        logger.debug("#################Entering Payment");

        List<Integer> res = tblUsersConsumeMapper.findPayment();
        logger.debug("Paymentdata: {}", res);

        return res;
    }
    public List<Integer> findMaxOrderAmount()
    {
        logger.debug("#################Entering MaxOrderAmount");

        List<Integer> res = tblUsersConsumeMapper.findMaxOrderAmount();
        logger.debug("MaxOrderAmount: {}", res);

        return res;
    }

    public List<Integer> findMaxOrderRange()
    {
        logger.debug("#################Entering MaxOrderRange");

        List<Integer> res = tblUsersConsumeMapper.findMaxOrderRange();
        logger.debug("MaxOrderRange: {}", res);

        return res;
    }
    public List<Integer> findFrequency()
    {
        logger.debug("#################Entering Frequency");

        List<Integer> res = tblUsersConsumeMapper.findFrequency();
        logger.debug("Frequency: {}", res);

        return res;
    }

    public List<Integer> findFreqValue()
    {
        logger.debug("#################Entering FreqValue");

        List<Integer> res = tblUsersConsumeMapper.findFreqValue();
        logger.debug("FFreqValue: {}", res);

        return res;
    }

    public List<Integer> findReturnRate()
    {
        logger.debug("#################Entering ReturnRate");

        List<Integer> res = tblUsersConsumeMapper.findReturnRate();
        logger.debug("ReturnRate: {}", res);

        return res;
    }

    public List<Integer> findRetValue()
    {
        logger.debug("#################Entering RetValue");

        List<Integer> res = tblUsersConsumeMapper.findRetValue();
        logger.debug("RetValue: {}", res);

        return res;
    }

    public List<Integer> findExchangeRate()
    {
        logger.debug("#################Entering ExchangeRate");

        List<Integer> res = tblUsersConsumeMapper.findExchangeRate();
        logger.debug("ExchangeRate: {}", res);

        return res;
    }
    public List<Integer> findExcValue()
    {
        logger.debug("#################Entering ExcValue");

        List<Integer> res = tblUsersConsumeMapper.findExcValue();
        logger.debug("ExcValue: {}", res);

        return res;
    }
    public List<Integer> findRfm()
    {
        logger.debug("#################Entering Rfm");

        List<Integer> res = tblUsersConsumeMapper.findRfm();
        logger.debug("Rfm: {}", res);

        return res;
    }

    public List<Integer> findPsm()
    {
        logger.debug("#################Entering Psm");

        List<Integer> res = tblUsersConsumeMapper.findPsm();
        logger.debug("Psm: {}", res);

        return res;
    }

    public List<Integer> findAllFrequency()
    {
        logger.debug("#################Entering find==All===Frequency");

        List<Integer> res = tblUsersConsumeMapper.findAllFrequency();
        logger.debug("All Frequency: {}", res);

        return res;
    }

    public List<Integer> findAllUnitPrice()
    {
        logger.debug("#################Entering find==All===UnitPrice");

        List<Integer> res = tblUsersConsumeMapper.findAllUnitPrice();
        logger.debug("All UnitPrice: {}", res);

        return res;
    }
    public List<Integer> findAllMaxOrderAmount()
    {
        logger.debug("#################Entering find==All===MaxOrderAmount");

        List<Integer> res = tblUsersConsumeMapper.findAllMaxOrderAmount();
        logger.debug("All max order amount: {}", res);

        return res;
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
