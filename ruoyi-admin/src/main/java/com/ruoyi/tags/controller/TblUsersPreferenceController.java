package com.ruoyi.tags.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.tags.domain.TblUsersPreference;
import com.ruoyi.tags.service.ITblUsersPreferenceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 兴趣特征1Controller
 * 
 * @author uus
 * @date 2024-03-16
 */
@RestController
@RequestMapping("/tags/preference")
public class TblUsersPreferenceController extends BaseController
{
    @Autowired
    private ITblUsersPreferenceService tblUsersPreferenceService;

    /**
     * 查询兴趣特征1列表
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblUsersPreference tblUsersPreference)
    {
        startPage();
        List<TblUsersPreference> list = tblUsersPreferenceService.selectTblUsersPreferenceList(tblUsersPreference);
        return getDataTable(list);
    }

    /**
     * 导出兴趣特征1列表
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:export')")
    @Log(title = "兴趣特征1", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblUsersPreference tblUsersPreference)
    {
        List<TblUsersPreference> list = tblUsersPreferenceService.selectTblUsersPreferenceList(tblUsersPreference);
        ExcelUtil<TblUsersPreference> util = new ExcelUtil<TblUsersPreference>(TblUsersPreference.class);
        util.exportExcel(response, list, "兴趣特征1数据");
    }

    @GetMapping("/datalist")
    public AjaxResult datalist() {
        List<Integer> loginCycleList = tblUsersPreferenceService.findByLoginCycle();
        List<Integer> frequencyList = tblUsersPreferenceService.findByFrequency();
        List<Integer> freqValueList = tblUsersPreferenceService.findByFreqValue();
        List<Integer> timeSlotList = tblUsersPreferenceService.findByTimeSlot();
        List<Integer> usgList = tblUsersPreferenceService.findByUsg();
        List<Integer> rfeList = tblUsersPreferenceService.findByRfe();
        List<Integer> top1List = tblUsersPreferenceService.findBytop1();
        List<Integer> top2List = tblUsersPreferenceService.findBytop2();
        List<Integer> top3List = tblUsersPreferenceService.findBytop3();
        List<Integer> top4List = tblUsersPreferenceService.findBytop4();
        List<Integer> top5List = tblUsersPreferenceService.findBytop5();

        Map<String, List<Integer>> dataList = new HashMap<>();
        dataList.put("loginCycleList", loginCycleList);
        dataList.put("frequencyList", frequencyList);
        dataList.put("freqValueList", freqValueList);
        dataList.put("timeSlotList", timeSlotList);
        dataList.put("usgList", usgList);
        dataList.put("rfeList", rfeList);
        dataList.put("top1List", top1List);
        dataList.put("top2List", top2List);
        dataList.put("top3List", top3List);
        dataList.put("top4List", top4List);
        dataList.put("top5List", top5List);

        return AjaxResult.success(dataList);
    }


    /**
     * 获取兴趣特征1详细信息
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(tblUsersPreferenceService.selectTblUsersPreferenceById(id));
    }

    /**
     * 新增兴趣特征1
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:add')")
    @Log(title = "兴趣特征1", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblUsersPreference tblUsersPreference)
    {
        return toAjax(tblUsersPreferenceService.insertTblUsersPreference(tblUsersPreference));
    }

    /**
     * 修改兴趣特征1
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:edit')")
    @Log(title = "兴趣特征1", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblUsersPreference tblUsersPreference)
    {
        return toAjax(tblUsersPreferenceService.updateTblUsersPreference(tblUsersPreference));
    }

    /**
     * 删除兴趣特征1
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:remove')")
    @Log(title = "兴趣特征1", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tblUsersPreferenceService.deleteTblUsersPreferenceByIds(ids));
    }
}
