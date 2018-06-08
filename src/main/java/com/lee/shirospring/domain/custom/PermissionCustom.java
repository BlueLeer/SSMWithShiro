package com.lee.shirospring.domain.custom;

import com.lee.shirospring.domain.Permission;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with : IntelliJ IDEA
 * User : KingIsHappy
 * Date : 2018/6/8
 * Time : 16:03
 * Description :
 */
@Getter
@Setter
@ToString
public class PermissionCustom extends Permission {
    /**
     * 用户的id
     */
    private String userid;
    /**
     * 用户的名字
     */
    private String username;
}
