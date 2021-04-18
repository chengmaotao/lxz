package com.ruoyi.app.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 客户等级配置对象 app_user_gradle_config
 *
 * @author ctc
 * @date 2021-04-18
 */
public class AppUserGradleConfig extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long id;

    /**
     *
     */
    @Excel(name = "")
    private Integer money;

    /**
     * 级别
     */
    @Excel(name = "级别")
    private String gradle;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public void setGradle(String gradle) {
        this.gradle = gradle;
    }

    public String getGradle() {
        return gradle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("money", getMoney())
                .append("gradle", getGradle())
                .toString();
    }
}
