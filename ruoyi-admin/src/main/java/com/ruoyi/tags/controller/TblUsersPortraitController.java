package com.ruoyi.tags.controller;

import java.util.List;
import com.google.gson.Gson;
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
import com.ruoyi.tags.domain.TblUsersPortrait;
import com.ruoyi.tags.service.ITblUsersPortraitService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户特征Controller
 * 
 * @author uus
 * @date 2024-03-13
 */
@RestController
@RequestMapping("/tags/portrait")
public class TblUsersPortraitController extends BaseController
{
    @Autowired
    private ITblUsersPortraitService tblUsersPortraitService;

    /**
     * 查询用户特征列表
     */
    @PreAuthorize("@ss.hasPermi('tags:portrait:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblUsersPortrait tblUsersPortrait)
    {
        startPage();
        List<TblUsersPortrait> list = tblUsersPortraitService.selectTblUsersPortraitList(tblUsersPortrait);
        return getDataTable(list);
    }

//    @PreAuthorize("@ss.hasPermi('tags:portrait:genderlist')")
//    @GetMapping("/genderlist")
//    public List<Integer> genderlist()
//    {
//        return tblUsersPortraitService.findByGender();
//    }
//
////    public AjaxResult genderlist()
////    {
////        List<Integer> genderlist= tblUsersPortraitService.findByGender();
////        return genderlist;
////    }
    @GetMapping("/genderlist")
    public AjaxResult genderlist() {
        List<Integer> genderList = tblUsersPortraitService.findByGender();
        return AjaxResult.success(genderList);
    }


    /**
     * 导出用户特征列表
     */
    @PreAuthorize("@ss.hasPermi('tags:portrait:export')")
    @Log(title = "用户特征", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblUsersPortrait tblUsersPortrait)
    {
        List<TblUsersPortrait> list = tblUsersPortraitService.selectTblUsersPortraitList(tblUsersPortrait);
        ExcelUtil<TblUsersPortrait> util = new ExcelUtil<TblUsersPortrait>(TblUsersPortrait.class);
        util.exportExcel(response, list, "用户特征数据");
    }

    /**
     * 获取用户特征详细信息
     */
    @PreAuthorize("@ss.hasPermi('tags:portrait:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(tblUsersPortraitService.selectTblUsersPortraitById(id));
    }

    /**
     * 新增用户特征
     */
    @PreAuthorize("@ss.hasPermi('tags:portrait:add')")
    @Log(title = "用户特征", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblUsersPortrait tblUsersPortrait)
    {
        return toAjax(tblUsersPortraitService.insertTblUsersPortrait(tblUsersPortrait));
    }

    /**
     * 修改用户特征
     */
    @PreAuthorize("@ss.hasPermi('tags:portrait:edit')")
    @Log(title = "用户特征", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblUsersPortrait tblUsersPortrait)
    {
        return toAjax(tblUsersPortraitService.updateTblUsersPortrait(tblUsersPortrait));
    }

    /**
     * 删除用户特征
     */
    @PreAuthorize("@ss.hasPermi('tags:portrait:remove')")
    @Log(title = "用户特征", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tblUsersPortraitService.deleteTblUsersPortraitByIds(ids));
    }
}
