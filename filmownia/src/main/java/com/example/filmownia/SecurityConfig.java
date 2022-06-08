//package com.example.filmownia;
//
//
//import com.example.filmownia.views.list.LoginView;
//import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends VaadinWebSecurityConfigurerAdapter {
//    private final SecurityService securityService;
//
//    public SecurityConfig(SecurityService securityService) {
//        this.securityService = securityService;
//    }
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//
//        setLoginView(http, LoginView.class);
//    }
//
//    /**
//     * Allows access to static resources, bypassing Spring security.
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/");
//        super.configure(web);
//    }
//
//
//
//}