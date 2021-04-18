package com.ruoyi.app.mapper;

import java.util.List;
import com.ruoyi.app.domain.AppUsers;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 客户端用户信息Mapper接口
 * 
 * @author ctc
 * @date 2021-04-18
 */
public interface AppUsersMapper 
{
    /**
     * 查询客户端用户信息
     * 
     * @param userId 客户端用户信息ID
     * @return 客户端用户信息
     */
    public AppUsers selectAppUsersById(Long userId);

    /**
     * 查询客户端用户信息列表
     * 
     * @param appUsers 客户端用户信息
     * @return 客户端用户信息集合
     */
    public List<AppUsers> selectAppUsersList(AppUsers appUsers);

    /**
     * 新增客户端用户信息
     * 
     * @param appUsers 客户端用户信息
     * @return 结果
     */
    public int insertAppUsers(AppUsers appUsers);

    /**
     * 修改客户端用户信息
     * 
     * @param appUsers 客户端用户信息
     * @return 结果
     */
    public int updateAppUsers(AppUsers appUsers);

    /**
     * 删除客户端用户信息
     * 
     * @param userId 客户端用户信息ID
     * @return 结果
     */
    public int deleteAppUsersById(Long userId);

    /**
     * 批量删除客户端用户信息
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAppUsersByIds(String[] userIds);


    /**
     * 校验用户名称是否唯一
     *
     * @param loginName 登录名称
     * @return 结果
     */
    public int checkLoginNameUnique(String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号码
     * @return 结果
     */
    public AppUsers checkPhoneUnique(String phonenumber);

    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
    public AppUsers checkEmailUnique(String email);

}
