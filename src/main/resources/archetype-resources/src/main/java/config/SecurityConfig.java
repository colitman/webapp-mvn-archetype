#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.config;

import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Spring security configuration
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	private @Value("${symbol_dollar}{environment.heroku}") boolean onHeroku;

	/**
	 * HTTP security configuration
     */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);
		
		if(!onHeroku) {
			http.requiresChannel().anyRequest().requiresSecure();
		}
        
        http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/[[sign_up_page]]", "/favicon.ico" , WebMvcConfig.RESOURCES_BASE_URL).permitAll()
				.and()
			.formLogin()
				.loginPage("/[[sign_in_page]]").permitAll()
				.loginProcessingUrl("/[[sign_in_page]]")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/", false)
				.failureUrl("/[[sign_in_page]]?error")
				.and()
			.logout()
				.logoutUrl("/[[sign_out_page]]")
				.logoutSuccessUrl("/[[sign_in_page]]")
				.invalidateHttpSession(true)
				.and()
			.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);
	}

	/**
	 * Authentication configuration
     */
	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
}
