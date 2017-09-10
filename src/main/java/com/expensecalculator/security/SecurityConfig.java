package com.expensecalculator.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/addStaff").hasRole("ADMIN").antMatchers("/addUser").hasAnyRole("ADMIN or USER")
				.and().formLogin().loginPage("/").loginProcessingUrl("/").usernameParameter("username")
				.passwordParameter("password");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("iftekhar09").password("abc").authorities("ROLE_ADMIN");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}
}