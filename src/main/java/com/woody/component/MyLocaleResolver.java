package com.woody.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 编写国际化环境
 */
public class MyLocaleResolver implements LocaleResolver {

    /**
     * 在该方法中重写
     * @param httpServletRequest
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // 1. 若是没写则是默认的
        Locale locale = Locale.getDefault();
        // 2. 获得参数
        String l = httpServletRequest.getParameter("l");
        // 3. 处理请求
        if (!StringUtils.isEmpty(l)) {
            String[] strings = l.split("_");
            locale = new Locale(strings[0], strings[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
