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
import com.ruoyi.tags.domain.TblUserProfile;
import com.ruoyi.tags.service.ITblUserProfileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 单人画像Controller
 * 
 * @author uus
 * @date 2024-03-16
 */
@RestController
@RequestMapping("/tags/profile")
public class TblUserProfileController extends BaseController
{
    @Autowired
    private ITblUserProfileService tblUserProfileService;

    /**
     * 查询单人画像列表
     */
    @PreAuthorize("@ss.hasPermi('tags:profile:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblUserProfile tblUserProfile)
    {
        startPage();
        List<TblUserProfile> list = tblUserProfileService.selectTblUserProfileList(tblUserProfile);
        return getDataTable(list);
    }

    /**
     * 导出单人画像列表
     */
    @PreAuthorize("@ss.hasPermi('tags:profile:export')")
    @Log(title = "单人画像", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblUserProfile tblUserProfile)
    {
        List<TblUserProfile> list = tblUserProfileService.selectTblUserProfileList(tblUserProfile);
        ExcelUtil<TblUserProfile> util = new ExcelUtil<TblUserProfile>(TblUserProfile.class);
        util.exportExcel(response, list, "单人画像数据");
    }

    /**
     * 获取单人画像详细信息
     */
    @PreAuthorize("@ss.hasPermi('tags:profile:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(tblUserProfileService.selectTblUserProfileByUserId(userId));
    }

    /**
     * 新增单人画像
     */
    @PreAuthorize("@ss.hasPermi('tags:profile:add')")
    @Log(title = "单人画像", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblUserProfile tblUserProfile)
    {
        return toAjax(tblUserProfileService.insertTblUserProfile(tblUserProfile));
    }

    /**
     * 修改单人画像
     */
    @PreAuthorize("@ss.hasPermi('tags:profile:edit')")
    @Log(title = "单人画像", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblUserProfile tblUserProfile)
    {
        return toAjax(tblUserProfileService.updateTblUserProfile(tblUserProfile));
    }

    /**
     * 删除单人画像
     */
    @PreAuthorize("@ss.hasPermi('tags:profile:remove')")
    @Log(title = "单人画像", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(tblUserProfileService.deleteTblUserProfileByUserIds(userIds));
    }
}
