package com.yxd.order.service;

import com.yxd.bo.UserBO;
import com.yxd.pojo.Users;

public interface UserService {
    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUserNameIsExist(String username);

    /**
     * 创建用户
     * @param userBO
     * @return
     */
    public Users createUse(UserBO userBO);

    /**
     * 检索用户密码是否匹配用户登录
     * @param username
     * @param password
     * @return
     */
    public Users queryUserForLogin(String username,String password);
}
