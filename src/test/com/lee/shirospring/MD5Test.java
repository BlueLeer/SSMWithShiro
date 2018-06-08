package com.lee.shirospring;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 生成md5
 */
public class MD5Test {

    public static void main(String[] args) {
        Md5Hash hash = new Md5Hash("666", "admin", 2);
        System.out.println(hash);
    }
}
