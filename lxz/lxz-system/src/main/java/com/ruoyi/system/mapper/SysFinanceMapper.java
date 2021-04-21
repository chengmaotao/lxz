package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysFinance;

/**
 * 金融信息Mapper接口
 * 
 * @author ctc
 * @date 2021-04-21
 */
public interface SysFinanceMapper 
{
    /**
     * 查询金融信息
     * 
     * @param id 金融信息ID
     * @return 金融信息
     */
    public SysFinance selectSysFinanceById(Long id);

    /**
     * 查询金融信息列表
     * 
     * @param sysFinance 金融信息
     * @return 金融信息集合
     */
    public List<SysFinance> selectSysFinanceList(SysFinance sysFinance);

    /**
     * 新增金融信息
     * 
     * @param sysFinance 金融信息
     * @return 结果
     */
    public int insertSysFinance(SysFinance sysFinance);

    /**
     * 修改金融信息
     * 
     * @param sysFinance 金融信息
     * @return 结果
     */
    public int updateSysFinance(SysFinance sysFinance);

    /**
     * 删除金融信息
     * 
     * @param id 金融信息ID
     * @return 结果
     */
    public int deleteSysFinanceById(Long id);

    /**
     * 批量删除金融信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysFinanceByIds(String[] ids);
}
