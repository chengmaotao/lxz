package com.ruoyi.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppUserGradleConfigMapper;
import com.ruoyi.app.domain.AppUserGradleConfig;
import com.ruoyi.app.service.IAppUserGradleConfigService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户等级配置Service业务层处理
 * 
 * @author ctc
 * @date 2021-04-18
 */
@Service
public class AppUserGradleConfigServiceImpl implements IAppUserGradleConfigService 
{
    @Autowired
    private AppUserGradleConfigMapper appUserGradleConfigMapper;

    /**
     * 查询客户等级配置
     * 
     * @param id 客户等级配置ID
     * @return 客户等级配置
     */
    @Override
    public AppUserGradleConfig selectAppUserGradleConfigById(Long id)
    {
        return appUserGradleConfigMapper.selectAppUserGradleConfigById(id);
    }

    /**
     * 查询客户等级配置列表
     * 
     * @param appUserGradleConfig 客户等级配置
     * @return 客户等级配置
     */
    @Override
    public List<AppUserGradleConfig> selectAppUserGradleConfigList(AppUserGradleConfig appUserGradleConfig)
    {
        return appUserGradleConfigMapper.selectAppUserGradleConfigList(appUserGradleConfig);
    }

    /**
     * 新增客户等级配置
     * 
     * @param appUserGradleConfig 客户等级配置
     * @return 结果
     */
    @Override
    public int insertAppUserGradleConfig(AppUserGradleConfig appUserGradleConfig)
    {
        return appUserGradleConfigMapper.insertAppUserGradleConfig(appUserGradleConfig);
    }

    /**
     * 修改客户等级配置
     * 
     * @param appUserGradleConfig 客户等级配置
     * @return 结果
     */
    @Override
    public int updateAppUserGradleConfig(AppUserGradleConfig appUserGradleConfig)
    {
        return appUserGradleConfigMapper.updateAppUserGradleConfig(appUserGradleConfig);
    }

    /**
     * 删除客户等级配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAppUserGradleConfigByIds(String ids)
    {
        return appUserGradleConfigMapper.deleteAppUserGradleConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户等级配置信息
     * 
     * @param id 客户等级配置ID
     * @return 结果
     */
    @Override
    public int deleteAppUserGradleConfigById(Long id)
    {
        return appUserGradleConfigMapper.deleteAppUserGradleConfigById(id);
    }
}
