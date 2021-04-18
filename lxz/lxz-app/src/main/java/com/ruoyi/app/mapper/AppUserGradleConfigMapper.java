package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppUserGradleConfig;

/**
 * 客户等级配置Mapper接口
 * 
 * @author ctc
 * @date 2021-04-18
 */
public interface AppUserGradleConfigMapper 
{
    /**
     * 查询客户等级配置
     * 
     * @param id 客户等级配置ID
     * @return 客户等级配置
     */
    public AppUserGradleConfig selectAppUserGradleConfigById(Long id);

    /**
     * 查询客户等级配置列表
     * 
     * @param appUserGradleConfig 客户等级配置
     * @return 客户等级配置集合
     */
    public List<AppUserGradleConfig> selectAppUserGradleConfigList(AppUserGradleConfig appUserGradleConfig);

    /**
     * 新增客户等级配置
     * 
     * @param appUserGradleConfig 客户等级配置
     * @return 结果
     */
    public int insertAppUserGradleConfig(AppUserGradleConfig appUserGradleConfig);

    /**
     * 修改客户等级配置
     * 
     * @param appUserGradleConfig 客户等级配置
     * @return 结果
     */
    public int updateAppUserGradleConfig(AppUserGradleConfig appUserGradleConfig);

    /**
     * 删除客户等级配置
     * 
     * @param id 客户等级配置ID
     * @return 结果
     */
    public int deleteAppUserGradleConfigById(Long id);

    /**
     * 批量删除客户等级配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAppUserGradleConfigByIds(String[] ids);
}
