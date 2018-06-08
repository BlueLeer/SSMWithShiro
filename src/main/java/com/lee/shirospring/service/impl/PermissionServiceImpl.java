package com.lee.shirospring.service.impl;

import com.lee.shirospring.dao.mapper.PermissionMapper;
import com.lee.shirospring.dao.mapper.PermissionMapperCustom;
import com.lee.shirospring.domain.Permission;
import com.lee.shirospring.domain.PermissionExample;
import com.lee.shirospring.domain.custom.PermissionCustom;
import com.lee.shirospring.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with : IntelliJ IDEA
 * User : KingIsHappy
 * Date : 2018/6/8
 * Time : 16:08
 * Description :
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private PermissionMapperCustom permissionMapperCustom;

    @Override
    public void insertPermission(Permission permission) throws Exception {
        permissionMapper.insert(permission);
    }

    @Override
    public List<PermissionCustom> selectPermissionsByUsername(String username) throws Exception {

        return permissionMapperCustom.selectPermissionByUsername(username);
    }

    @Override
    public List<String> selectRolesByUsername(String username) throws Exception {
        return permissionMapperCustom.selectRolesByUsername(username);
    }


}
