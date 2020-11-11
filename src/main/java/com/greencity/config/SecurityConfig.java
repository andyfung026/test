package com.greencity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author andy Fung
 * @date 2019/6/18 14:15
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 创建一个用户：admin / password。拥有角色：ADMIN、API
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN", "API");
    }

    // 创建一个过滤条件：对/v2/api-docs要求有API或ADMIN权限。
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().disable()
                .httpBasic().and().authorizeRequests().antMatchers("/v2/api-docs").hasAnyRole("ADMIN", "API");

    }
}
