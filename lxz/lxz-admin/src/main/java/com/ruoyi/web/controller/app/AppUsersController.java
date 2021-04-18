package com.ruoyi.app.controller;

import com.ruoyi.app.domain.AppUsers;
import com.ruoyi.app.service.IAppUsersService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 客户端用户信息Controller
 *
 * @author ctc
 * @date 2021-04-18
 */
@Controller
@RequestMapping("/app/users")
public class AppUsersController extends BaseController {
    private String prefix = "app/users";

    @Autowired
    private IAppUsersService appUsersService;

    @Autowired
    private SysPasswordService passwordService;

    @RequiresPermissions("app:users:view")
    @GetMapping()
    public String users() {
        return prefix + "/users";
    }

    /**
     * 查询客户端用户信息列表
     */
    @RequiresPermissions("app:users:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AppUsers appUsers) {
        startPage();
        List<AppUsers> list = appUsersService.selectAppUsersList(appUsers);
        return getDataTable(list);
    }

    /**
     * 导出客户端用户信息列表
     */
    @RequiresPermissions("app:users:export")
    @Log(title = "客户端用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AppUsers appUsers) {
        List<AppUsers> list = appUsersService.selectAppUsersList(appUsers);
        ExcelUtil<AppUsers> util = new ExcelUtil<AppUsers>(AppUsers.class);
        return util.exportExcel(list, "客户端用户信息数据");
    }

    /**
     * 新增客户端用户信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存客户端用户信息
     */
    @RequiresPermissions("app:users:add")
    @Log(title = "客户端用户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AppUsers appUsers) {
        return toAjax(appUsersService.insertAppUsers(appUsers));
    }

    /**
     * 修改客户端用户信息
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        AppUsers appUsers = appUsersService.selectAppUsersById(userId);
        mmap.put("appUsers", appUsers);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户端用户信息
     */
    @RequiresPermissions("app:users:edit")
    @Log(title = "客户端用户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AppUsers appUsers) {

        appUsers.setUpdateBy(ShiroUtils.getLoginName());
        appUsers.setUpdateTime(new Date());

        return toAjax(appUsersService.updateAppUsers(appUsers));
    }

    /**
     * 删除客户端用户信息
     */
    @RequiresPermissions("app:users:remove")
    @Log(title = "客户端用户信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {

        return toAjax(appUsersService.deleteAppUsersByIds(ids));
    }


    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(AppUsers user) {
        return appUsersService.checkLoginNameUnique(user.getLoginName());
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(AppUsers user) {
        return appUsersService.checkPhoneUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(AppUsers user) {
        return appUsersService.checkEmailUnique(user);
    }


    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, ModelMap mmap) {
        mmap.put("user", appUsersService.selectAppUsersById(userId));
        return prefix + "/resetPwd";
    }

    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(AppUsers user) {
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        user.setUpdateBy(ShiroUtils.getLoginName());
        user.setUpdateTime(new Date());
        if (appUsersService.resetUserPwd(user) > 0) {
            return success();
        }
        return error();
    }
}
