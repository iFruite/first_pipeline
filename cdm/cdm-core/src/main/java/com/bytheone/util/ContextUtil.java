package com.bytheone.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author ArtLinty
 * @date 2017/12/6.
 * @email liu.tingli@qq.com
 * 获取上下文
 */
public class ContextUtil {

    public static HttpServletRequest getServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public static HttpSession getSession() {
        return getServletRequest().getSession();
    }

}
