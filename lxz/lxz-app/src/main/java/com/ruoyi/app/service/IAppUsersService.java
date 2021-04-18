package com.ruoyi.app.service;

import com.ruoyi.app.domain.AppUsers;

import java.util.List;

/**
 * 客户端用户信息Service接口
 *
 * @author ctc
 * @date 2021-04-18
 */
public interface IAppUsersService {
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
     * 批量删除客户端用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAppUsersByIds(String ids);

    /**
     * 删除客户端用户信息信息
     *
     * @param userId 客户端用户信息ID
     * @return 结果
     */
    public int deleteAppUsersById(Long userId);


    /**
     * 校验用户名称是否唯一
     *
     * @param loginName 登录名称
     * @return 结果
     */
    public String checkLoginNameUnique(String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkPhoneUnique(AppUsers user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkEmailUnique(AppUsers user);

    /**
     * 修改用户密码信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int resetUserPwd(AppUsers user);
}
