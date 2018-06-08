package com.lee.shirospring.dao.mapper;

import com.lee.shirospring.domain.custom.PermissionCustom;

import java.util.List;

/**
 * Created with : IntelliJ IDEA
 * User : KingIsHappy
 * Date : 2018/6/8
 * Time : 16:02
 * Description : permission(权限) mapper
 */
public interface PermissionMapperCustom {
    List<PermissionCustom> selectPermissionByUsername(String username);

    List<String> selectRolesByUsername(String username);
}
