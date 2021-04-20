package com.ruoyi.web.controller.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户端用户信息Controller
 *
 * @author ctc
 * @date 2021-04-18
 */
@Controller
@RequestMapping("/app/data")
public class AppDataController extends BaseController {
    private String prefix = "app/data";

    @Autowired
    private IAppUsersService appUsersService;

    @Autowired
    private SysPasswordService passwordService;

    @RequiresPermissions("app:data:view")
    @GetMapping("/statistics")
    public String users() {
        return prefix + "/statistics";
    }


    @RequiresPermissions("app:data:view")
    @GetMapping("/statisticsRes")
    @ResponseBody
    public JSONObject users(Integer codeType) {

        JSONObject res = new JSONObject();

        List<String> xAxisData = null;


        // 购买人数
        if (codeType == null || codeType.intValue() != 1) {


            xAxisData = new ArrayList<>();

            xAxisData.add("理财三号");
            xAxisData.add("理财刘号");
            xAxisData.add("理财一号");
            xAxisData.add("理财就号");
            xAxisData.add("理财器号");

            res.put("xAxisData", xAxisData);

            List<Integer> datastatic = new ArrayList<>();
            datastatic.add(100);
            datastatic.add(33);
            datastatic.add(34);
            datastatic.add(234);
            datastatic.add(234);

            res.put("datastatic", datastatic);
        } else {
            // 购买金额


            //{value:235, name:'视频广告'},

            JSONArray amountArray = new JSONArray();

            JSONObject amount1 = new JSONObject();
            amount1.put("value",123.45);
            amount1.put("name","股票三号");
            amountArray.add(amount1);


            JSONObject amount2 = new JSONObject();
            amount2.put("value",193.45);
            amount2.put("name","股票一号");
            amountArray.add(amount2);

            JSONObject amount3 = new JSONObject();
            amount3.put("value",223.45);
            amount3.put("name","股票吧号");
            amountArray.add(amount3);


            JSONObject amount4 = new JSONObject();
            amount4.put("value",223.45);
            amount4.put("name","股票刘号");
            amountArray.add(amount4);


            JSONObject amount5 = new JSONObject();
            amount5.put("value",173.45);
            amount5.put("name","股票n号");
            amountArray.add(amount5);

            JSONObject amount6 = new JSONObject();
            amount6.put("value",163.45);
            amount6.put("name","股票si号");
            amountArray.add(amount6);


            res.put("amountStatistics", amountArray);
        }

        return res;

    }



}
