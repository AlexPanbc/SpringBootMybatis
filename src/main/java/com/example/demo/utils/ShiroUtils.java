package com.example.demo.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Shiro工具类
 * Created by panbingcan on 2018/1/8.
 */
public class ShiroUtils {

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }


    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }
    /**
     * 保存到session
     * @param key
     * @param value
     */
    public static void setSessionAttribute(Object key,Object value)
    {
        getSession().setAttribute(key,value);
    }

    public static String getKaptcha(String key) {
        Object kaptcha = getSessionAttribute(key);
        if (kaptcha == null)
            throw new RRException("验证码已失效");
        getSession().removeAttribute(key);
        return kaptcha.toString();
    }
}
