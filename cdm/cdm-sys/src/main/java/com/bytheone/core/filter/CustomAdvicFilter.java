package com.bytheone.core.filter;

import com.bytheone.service.MenuService;
import com.bytheone.service.SysUserService;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ArtLinty
 * @date 2017/12/13.
 * @email liu.tingli@qq.com
 * 自定义拦截器 暂时不用
 */
public class CustomAdvicFilter extends FormAuthenticationFilter {

    @Autowired
    private SysUserService userService;

    @Autowired
    private MenuService menuService;


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }
}
