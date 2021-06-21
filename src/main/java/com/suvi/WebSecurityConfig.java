package com.suvi;


//import javax.sql.DataSource;
 
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.suvi.service.SUserDetailsService;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //@Autowired
    //private DataSource dataSource;
     
    @Bean
    public UserDetailsService userDetailsService() {
        return new SUserDetailsService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("@@=====WebSecurityConfig==");
    	http
    		.csrf().disable()
    		.authorizeRequests()
    		.antMatchers("/**").permitAll()
    		.antMatchers("/signUp").permitAll()//hasAnyAuthority("ADMIN", "MEMBER", "GUEST", "USER")
    		.antMatchers("/new").hasAnyAuthority("ADMIN", "MEMBER")
	        .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "MEMBER")
	        .antMatchers("/delete/**").hasAuthority("ADMIN")
	        //.anyRequest().permitAll()
			.anyRequest().authenticated()
            .and()
            .formLogin()
            .usernameParameter("userName")
            .defaultSuccessUrl("/Welcome")
            .permitAll()
            .and()
            .logout()
            	.invalidateHttpSession(true)
            	.deleteCookies("JSESSIONID")
            	.logoutSuccessUrl("/?logout").permitAll();
            //.and()
            //.exceptionHandling().accessDeniedPage("/403");
    	/*
            .antMatchers("/Welcome").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
                .usernameParameter("user_name")
                .defaultSuccessUrl("/Welcome")
                .permitAll()
            .and()
            .logout().logoutSuccessUrl("/index").permitAll();*/

    }
     
}