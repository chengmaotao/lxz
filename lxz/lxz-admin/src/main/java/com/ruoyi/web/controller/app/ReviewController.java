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
import com.ruoyi.app.domain.Review;
import com.ruoyi.app.service.IReviewService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论管理Controller
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/app/review")
public class ReviewController extends BaseController
{
    private String prefix = "app/review";

    @Autowired
    private IReviewService reviewService;

    @RequiresPermissions("app:review:view")
    @GetMapping()
    public String review()
    {
        return prefix + "/review";
    }

    /**
     * 查询评论管理列表
     */
    @RequiresPermissions("app:review:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Review review)
    {
        startPage();
        List<Review> list = reviewService.selectReviewList(review);
        return getDataTable(list);
    }

    /**
     * 导出评论管理列表
     */
    @RequiresPermissions("app:review:export")
    @Log(title = "评论管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Review review)
    {
        List<Review> list = reviewService.selectReviewList(review);
        ExcelUtil<Review> util = new ExcelUtil<Review>(Review.class);
        return util.exportExcel(list, "评论管理数据");
    }

    /**
     * 新增评论管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评论管理
     */
    @RequiresPermissions("app:review:add")
    @Log(title = "评论管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Review review)
    {
        return toAjax(reviewService.insertReview(review));
    }

    /**
     * 修改评论管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Review review = reviewService.selectReviewById(id);
        mmap.put("review", review);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论管理
     */
    @RequiresPermissions("app:review:edit")
    @Log(title = "评论管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Review review)
    {
        return toAjax(reviewService.updateReview(review));
    }

    /**
     * 删除评论管理
     */
    @RequiresPermissions("app:review:remove")
    @Log(title = "评论管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(reviewService.deleteReviewByIds(ids));
    }
}
