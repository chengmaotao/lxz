package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 金融信息对象 sys_finance
 * 
 * @author ctc
 * @date 2021-04-21
 */
public class SysFinance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 金融产品的名称 */
    @Excel(name = "产品名称")
    private String name;

    /** 编号 */
    @Excel(name = "产品编号")
    private String financeId;

    /** 最小购买金额 */
    @Excel(name = "最小购买金额")
    private BigDecimal minNum;

    /** 最大购买金额 */
    @Excel(name = "最大购买金额")
    private BigDecimal maxNum;

    /** 开始购买时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 截止购买时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 产品发行总额 */
    @Excel(name = "产品发行总额")
    private BigDecimal allAmount;

    /** 产品周期(单位天） */
    @Excel(name = "产品周期(单位天）")
    private Long cycle;

    /** 日利率 */
    @Excel(name = "日利率")
    private BigDecimal dayRate;

    /** 1银卡 2 金卡 3钻石 */
    @Excel(name = "1银卡 2 金卡 3钻石")
    private Integer userGradle;

    /** 相关信息（就是一个url地址） */
    @Excel(name = "相关信息", readConverterExp = "就=是一个url地址")
    private String newsLink;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setFinanceId(String financeId) 
    {
        this.financeId = financeId;
    }

    public String getFinanceId() 
    {
        return financeId;
    }
    public void setMinNum(BigDecimal minNum) 
    {
        this.minNum = minNum;
    }

    public BigDecimal getMinNum() 
    {
        return minNum;
    }
    public void setMaxNum(BigDecimal maxNum) 
    {
        this.maxNum = maxNum;
    }

    public BigDecimal getMaxNum() 
    {
        return maxNum;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setAllAmount(BigDecimal allAmount) 
    {
        this.allAmount = allAmount;
    }

    public BigDecimal getAllAmount() 
    {
        return allAmount;
    }
    public void setCycle(Long cycle) 
    {
        this.cycle = cycle;
    }

    public Long getCycle() 
    {
        return cycle;
    }
    public void setDayRate(BigDecimal dayRate) 
    {
        this.dayRate = dayRate;
    }

    public BigDecimal getDayRate() 
    {
        return dayRate;
    }
    public void setUserGradle(Integer userGradle)
    {
        this.userGradle = userGradle;
    }

    public Integer getUserGradle()
    {
        return userGradle;
    }
    public void setNewsLink(String newsLink) 
    {
        this.newsLink = newsLink;
    }

    public String getNewsLink() 
    {
        return newsLink;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("financeId", getFinanceId())
            .append("minNum", getMinNum())
            .append("maxNum", getMaxNum())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("allAmount", getAllAmount())
            .append("cycle", getCycle())
            .append("dayRate", getDayRate())
            .append("userGradle", getUserGradle())
            .append("newsLink", getNewsLink())
            .toString();
    }
}
