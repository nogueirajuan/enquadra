package com.each.enquadra.config;

import com.each.enquadra.controller.login.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionFixation()
                .migrateSession()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .maximumSessions(1)
                .expiredUrl("/");

        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/dashboard/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").successForwardUrl("/dashboard/")
                .and()
                .logout()
                .logoutUrl("/login?logout")
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .permitAll();

        http.csrf().disable();
    }
}
