package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysFinanceMapper;
import com.ruoyi.system.domain.SysFinance;
import com.ruoyi.system.service.ISysFinanceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 金融信息Service业务层处理
 * 
 * @author ctc
 * @date 2021-04-21
 */
@Service
public class SysFinanceServiceImpl implements ISysFinanceService 
{
    @Autowired
    private SysFinanceMapper sysFinanceMapper;

    /**
     * 查询金融信息
     * 
     * @param id 金融信息ID
     * @return 金融信息
     */
    @Override
    public SysFinance selectSysFinanceById(Long id)
    {
        return sysFinanceMapper.selectSysFinanceById(id);
    }

    /**
     * 查询金融信息列表
     * 
     * @param sysFinance 金融信息
     * @return 金融信息
     */
    @Override
    public List<SysFinance> selectSysFinanceList(SysFinance sysFinance)
    {
        return sysFinanceMapper.selectSysFinanceList(sysFinance);
    }

    /**
     * 新增金融信息
     * 
     * @param sysFinance 金融信息
     * @return 结果
     */
    @Override
    public int insertSysFinance(SysFinance sysFinance)
    {
        return sysFinanceMapper.insertSysFinance(sysFinance);
    }

    /**
     * 修改金融信息
     * 
     * @param sysFinance 金融信息
     * @return 结果
     */
    @Override
    public int updateSysFinance(SysFinance sysFinance)
    {
        return sysFinanceMapper.updateSysFinance(sysFinance);
    }

    /**
     * 删除金融信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysFinanceByIds(String ids)
    {
        return sysFinanceMapper.deleteSysFinanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除金融信息信息
     * 
     * @param id 金融信息ID
     * @return 结果
     */
    @Override
    public int deleteSysFinanceById(Long id)
    {
        return sysFinanceMapper.deleteSysFinanceById(id);
    }
}
