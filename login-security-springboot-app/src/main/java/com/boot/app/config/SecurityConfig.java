package com.boot.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").access("permitAll")
		.antMatchers("/app/secure/**").hasAnyRole("ADMIN","USER")
	            .and().formLogin().loginPage("/app/login")
	            .loginProcessingUrl("/app-login")
	            .usernameParameter("app_username")
	            .passwordParameter("app_password").defaultSuccessUrl("/app/loginPass")
	            .and().logout().logoutUrl("/logout").invalidateHttpSession(true)
	            .and().exceptionHandling()
	            .accessDeniedPage("/app/error");
		
			http.csrf().disable();
		}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
	}
}