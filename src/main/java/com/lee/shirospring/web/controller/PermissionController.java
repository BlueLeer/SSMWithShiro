package com.lee.shirospring.web.controller;

import com.lee.shirospring.domain.Permission;
import com.lee.shirospring.realm.PermissionName;
import com.lee.shirospring.service.PermissionService;
import com.lee.shirospring.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //请求映射处理映射器
    //springmvc在启动时候将所有贴有请求映射标签：RequestMapper方法收集起来封装到该对象中
    @Autowired
    private RequestMappingHandlerMapping rmhm;

    /**
     * 将Handler方法上面带有RequiresPermissions和PermissionName注解的值包装成permission对象,存到数据库
     * @return
     * @throws Exception
     */
    @RequestMapping("/reload")
    public String reload() throws Exception {
        // 获取所有的Handler方法
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
        // 拿出所有的HandlerMethod
        Collection<HandlerMethod> values = handlerMethods.values();

        // 遍历所有的方法
        Iterator<HandlerMethod> iterator = values.iterator();
        while (iterator.hasNext()) {
            HandlerMethod method = iterator.next();
            // 获取注解上的权限resource
            RequiresPermissions methodAnnotation = method.getMethodAnnotation(RequiresPermissions.class);
            if (methodAnnotation == null) {
                continue;
            }
            String resource = methodAnnotation.value()[0];
            // 获取注解上面的权限说明
            PermissionName annotation = method.getMethodAnnotation(PermissionName.class);
            String name = annotation.value();


            // 将值插入到数据库中去
            Permission p = new Permission();
            p.setName(name);
            p.setResource(resource);
            // 插入数据库
            permissionService.insertPermission(p);
        }


        return "main";
    }

}
