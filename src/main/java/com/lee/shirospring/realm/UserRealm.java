package com.lee.shirospring.realm;

import com.lee.shirospring.domain.User;
import com.lee.shirospring.domain.custom.PermissionCustom;
import com.lee.shirospring.domain.custom.UserCustom;
import com.lee.shirospring.service.PermissionService;
import com.lee.shirospring.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    //认证操作
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取token中的用户名
        String username = (String) token.getPrincipal();
        // 根据用户名从数据库中查询用户
        User user_db = null;
        try {
            user_db = userService.queryUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 将查询出来的信息封装成AuthenticationInfo对象,然后返回
        if (user_db != null) {
            AuthenticationInfo info = new SimpleAuthenticationInfo(user_db, user_db.getPassword(), ByteSource.Util.bytes(username), getName());
            return info;
        }

        return null;
    }


    @Override
    public String getName() {
        return "UserRealm";
    }

    // 授权操作
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserCustom user = (UserCustom) principals.getPrimaryPrincipal();
        try {
            List<PermissionCustom> permissionCustoms = permissionService.selectPermissionsByUsername(user.getUsername());
            List<String> permissions = new ArrayList<>();
            List<String> roles = permissionService.selectRolesByUsername(user.getUsername());

            for (PermissionCustom p : permissionCustoms) {
                permissions.add(p.getResource());
            }

            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 将权限添加到info当中去
            info.addStringPermissions(permissions);
//            info.addRoles(roles);

            return info;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    //清除缓存
    public void clearCached() {
        //获取当前等的用户凭证，然后清除
//        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
//        super.clearCache(principals);
    }


}
