package com.bytheone.core.shiro;

import com.bytheone.base.CurrentUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author ArtLinty
 * @date 2017/12/28.
 * @email liu.tingli@qq.com
 */
public class ShiroUtil {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Session getSession() {
        return getSubject().getSession();
    }

    public static CurrentUser getCurrentUse() {
        return (CurrentUser) getSession().getAttribute("curentUser");
    }

}
