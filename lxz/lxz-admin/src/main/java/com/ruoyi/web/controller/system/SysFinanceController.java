package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysFinance;
import com.ruoyi.system.service.ISysFinanceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 金融信息Controller
 * 
 * @author ctc
 * @date 2021-04-21
 */
@Controller
@RequestMapping("/system/finance")
public class SysFinanceController extends BaseController
{
    private String prefix = "system/finance";

    @Autowired
    private ISysFinanceService sysFinanceService;

    @RequiresPermissions("system:finance:view")
    @GetMapping()
    public String finance()
    {
        return prefix + "/finance";
    }

    /**
     * 查询金融信息列表
     */
    @RequiresPermissions("system:finance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysFinance sysFinance)
    {
        startPage();
        List<SysFinance> list = sysFinanceService.selectSysFinanceList(sysFinance);
        return getDataTable(list);
    }

    /**
     * 导出金融信息列表
     */
    @RequiresPermissions("system:finance:export")
    @Log(title = "金融信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysFinance sysFinance)
    {
        List<SysFinance> list = sysFinanceService.selectSysFinanceList(sysFinance);
        ExcelUtil<SysFinance> util = new ExcelUtil<SysFinance>(SysFinance.class);
        return util.exportExcel(list, "金融信息数据");
    }

    /**
     * 新增金融信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存金融信息
     */
    @RequiresPermissions("system:finance:add")
    @Log(title = "金融信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysFinance sysFinance)
    {
        return toAjax(sysFinanceService.insertSysFinance(sysFinance));
    }

    /**
     * 修改金融信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysFinance sysFinance = sysFinanceService.selectSysFinanceById(id);
        mmap.put("sysFinance", sysFinance);
        return prefix + "/edit";
    }

    /**
     * 修改保存金融信息
     */
    @RequiresPermissions("system:finance:edit")
    @Log(title = "金融信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysFinance sysFinance)
    {
        return toAjax(sysFinanceService.updateSysFinance(sysFinance));
    }

    /**
     * 删除金融信息
     */
    @RequiresPermissions("system:finance:remove")
    @Log(title = "金融信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysFinanceService.deleteSysFinanceByIds(ids));
    }
}
