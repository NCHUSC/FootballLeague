package com.example.config;


import com.example.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

/*    public void addResouceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }*/


    //所有的WebMvcConfigurerAdapter组件会一起起作用
    //将组件注册在容器
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/index.html").setViewName("index");
            }

            /*//注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry){
                //super.addInterceptors(registry);
                //Springboot做好了静态资源映射，不需要排除静态资源
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html","/","/login");
            }*/
        };
        return adapter;
    }
}

