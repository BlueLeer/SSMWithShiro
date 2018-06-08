package com.lee.shirospring.service.impl;

import com.lee.shirospring.dao.mapper.PermissionMapper;
import com.lee.shirospring.dao.mapper.UserMapper;
import com.lee.shirospring.domain.Permission;
import com.lee.shirospring.domain.User;
import com.lee.shirospring.domain.UserExample;
import com.lee.shirospring.domain.custom.UserCustom;
import com.lee.shirospring.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with : IntelliJ IDEA
 * User : KingIsHappy
 * Date : 2018/6/7
 * Time : 23:31
 * Description :
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    /**
     * 认证
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public UserCustom queryUserByUsername(String username) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<User> users = userMapper.selectByExample(example);

        if (users == null || users.size() != 1) {
            return null;
        }

        User user = users.get(0);
        UserCustom custom = new UserCustom();
        BeanUtils.copyProperties(user, custom);
        return custom;
    }



}
