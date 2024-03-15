package com.ruoyi.tags.controller;

import java.util.List;
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
 * 兴趣特征Controller
 * 
 * @author uus
 * @date 2024-03-15
 */
@RestController
@RequestMapping("/tags/preference")
public class TblUsersPreferenceController extends BaseController
{
    @Autowired
    private ITblUsersPreferenceService tblUsersPreferenceService;

    /**
     * 查询兴趣特征列表
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
     * 导出兴趣特征列表
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:export')")
    @Log(title = "兴趣特征", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblUsersPreference tblUsersPreference)
    {
        List<TblUsersPreference> list = tblUsersPreferenceService.selectTblUsersPreferenceList(tblUsersPreference);
        ExcelUtil<TblUsersPreference> util = new ExcelUtil<TblUsersPreference>(TblUsersPreference.class);
        util.exportExcel(response, list, "兴趣特征数据");
    }

    /**
     * 获取兴趣特征详细信息
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(tblUsersPreferenceService.selectTblUsersPreferenceById(id));
    }

    /**
     * 新增兴趣特征
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:add')")
    @Log(title = "兴趣特征", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblUsersPreference tblUsersPreference)
    {
        return toAjax(tblUsersPreferenceService.insertTblUsersPreference(tblUsersPreference));
    }

    /**
     * 修改兴趣特征
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:edit')")
    @Log(title = "兴趣特征", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblUsersPreference tblUsersPreference)
    {
        return toAjax(tblUsersPreferenceService.updateTblUsersPreference(tblUsersPreference));
    }

    /**
     * 删除兴趣特征
     */
    @PreAuthorize("@ss.hasPermi('tags:preference:remove')")
    @Log(title = "兴趣特征", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tblUsersPreferenceService.deleteTblUsersPreferenceByIds(ids));
    }
}
