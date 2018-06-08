package com.lee.shirospring.dao.mapper;

import com.lee.shirospring.domain.Permission;
import com.lee.shirospring.domain.custom.PermissionCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with : IntelliJ IDEA
 * User : KingIsHappy
 * Date : 2018/6/8
 * Time : 16:16
 * Description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class PermissionMapperCustomTest {

    @Autowired
    private PermissionMapperCustom permissionMapperCustom;

    @Test
    public void selectPermissionByUsername() throws Exception {
        List<PermissionCustom> permissions = permissionMapperCustom.selectPermissionByUsername("zhangsan");
        for (PermissionCustom p : permissions) {
            System.out.println(p);
        }
    }

    @Test
    public void selectRolesByUsername() {
        List<String> zhangsan = permissionMapperCustom.selectRolesByUsername("zhangsan");
        for (String s : zhangsan) {
            System.out.println(s);
        }
    }

}