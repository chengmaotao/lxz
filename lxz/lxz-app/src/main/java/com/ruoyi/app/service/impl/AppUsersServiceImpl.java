package com.ruoyi.app.service.impl;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.AppUsersMapper;
import com.ruoyi.app.domain.AppUsers;
import com.ruoyi.app.service.IAppUsersService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户端用户信息Service业务层处理
 * 
 * @author ctc
 * @date 2021-04-18
 */
@Service
public class AppUsersServiceImpl implements IAppUsersService 
{
    @Autowired
    private AppUsersMapper appUsersMapper;

    /**
     * 查询客户端用户信息
     * 
     * @param userId 客户端用户信息ID
     * @return 客户端用户信息
     */
    @Override
    public AppUsers selectAppUsersById(Long userId)
    {
        return appUsersMapper.selectAppUsersById(userId);
    }

    /**
     * 查询客户端用户信息列表
     * 
     * @param appUsers 客户端用户信息
     * @return 客户端用户信息
     */
    @Override
    public List<AppUsers> selectAppUsersList(AppUsers appUsers)
    {
        return appUsersMapper.selectAppUsersList(appUsers);
    }

    /**
     * 新增客户端用户信息
     * 
     * @param appUsers 客户端用户信息
     * @return 结果
     */
    @Override
    public int insertAppUsers(AppUsers appUsers)
    {
        appUsers.setCreateTime(DateUtils.getNowDate());
        return appUsersMapper.insertAppUsers(appUsers);
    }

    /**
     * 修改客户端用户信息
     * 
     * @param appUsers 客户端用户信息
     * @return 结果
     */
    @Override
    public int updateAppUsers(AppUsers appUsers)
    {
        appUsers.setUpdateTime(DateUtils.getNowDate());
        return appUsersMapper.updateAppUsers(appUsers);
    }

    /**
     * 删除客户端用户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAppUsersByIds(String ids)
    {
        return appUsersMapper.deleteAppUsersByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户端用户信息信息
     * 
     * @param userId 客户端用户信息ID
     * @return 结果
     */
    @Override
    public int deleteAppUsersById(Long userId)
    {
        return appUsersMapper.deleteAppUsersById(userId);
    }


    @Override
    public String checkLoginNameUnique(String loginName) {
        int count = appUsersMapper.checkLoginNameUnique(loginName);
        if (count > 0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    @Override
    public String checkPhoneUnique(AppUsers user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        AppUsers info = appUsersMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    @Override
    public String checkEmailUnique(AppUsers user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        AppUsers info = appUsersMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_EMAIL_NOT_UNIQUE;
        }
        return UserConstants.USER_EMAIL_UNIQUE;
    }

    @Override
    public int resetUserPwd(AppUsers user) {
        return appUsersMapper.updateAppUsers(user);
    }
}
