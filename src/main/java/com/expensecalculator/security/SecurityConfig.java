package com.expensecalculator.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// @Autowired
	// PersistentTokenRepository tokenRepository;
	//
	// @Bean
	// public PasswordEncoder PasswordEncoder() {
	// return new BCryptPasswordEncoder(12);
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().antMatchers("/profile/**,/addExpense,/users","/register")
		// .access("hasRole('ADMIN')").and().formLogin().loginPage("/").loginProcessingUrl("/")
		// .usernameParameter("username").passwordParameter("password").and().rememberMe()
		// .rememberMeParameter("remember").tokenRepository(tokenRepository).tokenValiditySeconds(6400).and()
		// .csrf().and().exceptionHandling().accessDeniedPage("/accessDenied");

//		http.authorizeRequests().antMatchers("/register").access("hasRole('ADMIN')").and().formLogin().loginPage("/")
//				.loginProcessingUrl("/").usernameParameter("username").passwordParameter("password");
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