package com.springboot1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

/**
 * web 配置信息类
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * cookie 区域解析器
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        // 设置默认区域
        localeResolver.setDefaultLocale(Locale.CHINA);
        // 设置cookie 有效期
        localeResolver.setCookieMaxAge(3600);
        localeResolver.setCookieName("language");
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        // 设置请求地址的参数 默认: locale - carlist?locale=en_US
        //interceptor.setParamName(LocaleChangeInterceptor.DEFAULT_PARAM_NAME);

        // 自定义参数名 carlist?lang=zh_US
        //interceptor.setParamName("lang");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 把拦截器Bean 加入到配置类中
        registry.addInterceptor(localeChangeInterceptor());
    }
}
