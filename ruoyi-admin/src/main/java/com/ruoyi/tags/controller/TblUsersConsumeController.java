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
import com.ruoyi.tags.domain.TblUsersConsume;
import com.ruoyi.tags.service.ITblUsersConsumeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消费特征Controller
 * 
 * @author uus
 * @date 2024-03-15
 */
@RestController
@RequestMapping("/tags/consume")
public class TblUsersConsumeController extends BaseController
{
    @Autowired
    private ITblUsersConsumeService tblUsersConsumeService;

    /**
     * 查询消费特征列表
     */
    @PreAuthorize("@ss.hasPermi('tags:consume:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblUsersConsume tblUsersConsume)
    {
        startPage();
        List<TblUsersConsume> list = tblUsersConsumeService.selectTblUsersConsumeList(tblUsersConsume);
        return getDataTable(list);
    }

    /**
     * 导出消费特征列表
     */
    @PreAuthorize("@ss.hasPermi('tags:consume:export')")
    @Log(title = "消费特征", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblUsersConsume tblUsersConsume)
    {
        List<TblUsersConsume> list = tblUsersConsumeService.selectTblUsersConsumeList(tblUsersConsume);
        ExcelUtil<TblUsersConsume> util = new ExcelUtil<TblUsersConsume>(TblUsersConsume.class);
        util.exportExcel(response, list, "消费特征数据");
    }

    /**
     * 获取消费特征详细信息
     */
    @PreAuthorize("@ss.hasPermi('tags:consume:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(tblUsersConsumeService.selectTblUsersConsumeById(id));
    }

    /**
     * 新增消费特征
     */
    @PreAuthorize("@ss.hasPermi('tags:consume:add')")
    @Log(title = "消费特征", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblUsersConsume tblUsersConsume)
    {
        return toAjax(tblUsersConsumeService.insertTblUsersConsume(tblUsersConsume));
    }

    /**
     * 修改消费特征
     */
    @PreAuthorize("@ss.hasPermi('tags:consume:edit')")
    @Log(title = "消费特征", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblUsersConsume tblUsersConsume)
    {
        return toAjax(tblUsersConsumeService.updateTblUsersConsume(tblUsersConsume));
    }

    /**
     * 删除消费特征
     */
    @PreAuthorize("@ss.hasPermi('tags:consume:remove')")
    @Log(title = "消费特征", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tblUsersConsumeService.deleteTblUsersConsumeByIds(ids));
    }
}
