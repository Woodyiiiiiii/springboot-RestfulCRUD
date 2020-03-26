package com.woody.config;

import com.woody.component.LoginHandlerInterceptor;
import com.woody.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Locale;

/**
 * 扩展SpringMVC
 */
@Configuration
//@EnableWebMvc // 全面接管SpringMVC
// extends WebMvcConfigurationSupport 或者是 implements WebMvcConfigurer都可以
// 但不能是继承了WebMvcConfigurationAdapter，因为Springboot2.0以上版本已经抛弃了
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 浏览器发送任何请求，也来到login页面，类似于@RequestMapping
     * 这是默认访问首页的第二种方式(不同于下面的方式)
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/**").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         // SpringBoot已经处理了静态资源，所以不用访问
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/user/login", "/", "/main.html");
//                super.addInterceptors(registry);
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/js/**", "/css/**", "/images/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:static");
    }



    /**
     * 默认访问首页的第二种方式：
     * 所有的WebMvcConfigurationSupport组件都会一起起作用
     * 好像只有继承了WebMvcConfigurationAdapter才适用
     * 不推荐适用
     * @return
     */
//    @Bean // 将组件加载进Spring容器中
//    public WebMvcConfigurationSupport webMvcConfigurationSupport() {
//        WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport() {
//            @Override
//            protected void addViewControllers(ViewControllerRegistry registry) {
////                super.addViewControllers(registry);
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("dashboard");
//            }
//
//            @Override
//            protected void addInterceptors(InterceptorRegistry registry) {
//                // SpringBoot已经处理了静态资源，所以不用访问
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html", "/user/login", "/");
////                super.addInterceptors(registry);
//            }
//        };
//        return webMvcConfigurationSupport;
//    }


    /**
     * 添加国际化组件
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
