package com.lee.shirospring.service;

import com.lee.shirospring.domain.Permission;
import com.lee.shirospring.domain.custom.UserCustom;

/**
 * Created with : IntelliJ IDEA
 * User : KingIsHappy
 * Date : 2018/6/7
 * Time : 23:29
 * Description : 用户Service(所有用户)
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     * @throws Exception
     */
    UserCustom queryUserByUsername(String username) throws Exception;


}
