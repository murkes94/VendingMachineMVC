package com.vendingmachine.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages = {"com.vendingmachine"})
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views/";
    private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

    private static final String RESOURCE_PATH_PATTERN_ASSETS = "/assets/**";
    private static final String RESOURCE_LOCATION_ASSETS = "/WEB-INF/assets/";

    private static final String RESOURCE_PATH_PATTERN_LOCALE = "/locale/**";
    private static final String RESOURCE_LOCATION_LOCALE = "classpath:/locale/";

    private static final String RESOURCE_PATH_PATTERN_WEBJARS = "/webjars/**";
    private static final String RESOURCE_LOCATION_WEBJARS = "/webjars/";

    private static final String LOCALE_LANGUAGE_VOCABULARY_PATH = "classpath:/locale/language";
    private static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp().prefix(VIEW_RESOLVER_PREFIX).suffix(VIEW_RESOLVER_SUFFIX);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCE_PATH_PATTERN_ASSETS)
                .addResourceLocations(RESOURCE_LOCATION_ASSETS);
        registry.addResourceHandler(RESOURCE_PATH_PATTERN_LOCALE)
                .addResourceLocations(RESOURCE_LOCATION_LOCALE);
        registry.addResourceHandler(RESOURCE_PATH_PATTERN_WEBJARS)
                .addResourceLocations(RESOURCE_LOCATION_WEBJARS).resourceChain(false);
    }

    @Bean("messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(LOCALE_LANGUAGE_VOCABULARY_PATH);
        messageSource.setDefaultEncoding(DEFAULT_ENCODING);
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
        themeChangeInterceptor.setParamName("theme");
        registry.addInterceptor(themeChangeInterceptor);

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }

}
