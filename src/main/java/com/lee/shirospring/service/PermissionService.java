package com.lee.shirospring.service;

import com.lee.shirospring.domain.Permission;
import com.lee.shirospring.domain.custom.PermissionCustom;

import java.util.List;

/**
 * Created with : IntelliJ IDEA
 * User : KingIsHappy
 * Date : 2018/6/8
 * Time : 16:07
 * Description :
 */
public interface PermissionService {
    /**
     * 将permission插入到数据库中去
     *
     * @param permission
     * @throws Exception
     */
    void insertPermission(Permission permission) throws Exception;

    /**
     * 根据用户名查询用户拥有的权限
     *
     * @param username
     * @return
     * @throws Exception
     */
    List<PermissionCustom> selectPermissionsByUsername(String username) throws Exception;

    List<String> selectRolesByUsername(String username) throws Exception;
}
