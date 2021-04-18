package com.ruoyi.web.controller.app;

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
import com.ruoyi.app.domain.AppUserGradleConfig;
import com.ruoyi.app.service.IAppUserGradleConfigService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户等级配置Controller
 * 
 * @author ctc
 * @date 2021-04-18
 */
@Controller
@RequestMapping("/app/config")
public class AppUserGradleConfigController extends BaseController
{
    private String prefix = "app/config";

    @Autowired
    private IAppUserGradleConfigService appUserGradleConfigService;

    @RequiresPermissions("app:config:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/config";
    }

    /**
     * 查询客户等级配置列表
     */
    @RequiresPermissions("app:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AppUserGradleConfig appUserGradleConfig)
    {
        startPage();
        List<AppUserGradleConfig> list = appUserGradleConfigService.selectAppUserGradleConfigList(appUserGradleConfig);
        return getDataTable(list);
    }

    /**
     * 导出客户等级配置列表
     */
    @RequiresPermissions("app:config:export")
    @Log(title = "客户等级配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AppUserGradleConfig appUserGradleConfig)
    {
        List<AppUserGradleConfig> list = appUserGradleConfigService.selectAppUserGradleConfigList(appUserGradleConfig);
        ExcelUtil<AppUserGradleConfig> util = new ExcelUtil<AppUserGradleConfig>(AppUserGradleConfig.class);
        return util.exportExcel(list, "客户等级配置数据");
    }

    /**
     * 新增客户等级配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户等级配置
     */
    @RequiresPermissions("app:config:add")
    @Log(title = "客户等级配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AppUserGradleConfig appUserGradleConfig)
    {
        return toAjax(appUserGradleConfigService.insertAppUserGradleConfig(appUserGradleConfig));
    }

    /**
     * 修改客户等级配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AppUserGradleConfig appUserGradleConfig = appUserGradleConfigService.selectAppUserGradleConfigById(id);
        mmap.put("appUserGradleConfig", appUserGradleConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户等级配置
     */
    @RequiresPermissions("app:config:edit")
    @Log(title = "客户等级配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AppUserGradleConfig appUserGradleConfig)
    {
        return toAjax(appUserGradleConfigService.updateAppUserGradleConfig(appUserGradleConfig));
    }

    /**
     * 删除客户等级配置
     */
    @RequiresPermissions("app:config:remove")
    @Log(title = "客户等级配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(appUserGradleConfigService.deleteAppUserGradleConfigByIds(ids));
    }
}
