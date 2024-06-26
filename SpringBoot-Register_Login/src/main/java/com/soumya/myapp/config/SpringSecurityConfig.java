package com.soumya.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {
	
	private UserDetailsService userDetailsService;
	
	@Autowired
	private CustomSuccessHandler successHandler;

	@Autowired
	public SpringSecurityConfig(UserDetailsService userDetailsService) {
		
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((requests) ->  requests.
	              requestMatchers("/api/customers/dashboard",
	            		          "/api/customers/purchase/**",
	            		          "/api/customers/checkout/**",
	            		          "/api/customers/orders/**",
	            		          "/users/**",
	            		          "/products/**",
	            		          "/admin/dashboard/**").
	              authenticated().
	              anyRequest().permitAll()
	         
	         ).
		  formLogin((customizer) -> {
			  
			  customizer.loginPage("/signin").
			  loginProcessingUrl("/userLogin").
			  successHandler(this.successHandler).
			  failureUrl("/invalid").
			  permitAll();
			  
			 
		  }).
		  logout((customizer) -> 
		           customizer.logoutSuccessUrl("/logout/user").permitAll());
		
		http.csrf(csrf -> csrf.disable() );
		
		
		http.exceptionHandling( customizer -> customizer.accessDeniedHandler(new CustomAccessDeniedHandler()));
		 
		   
		
		 return http.build();
		
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider(@Autowired PasswordEncoder passwordEncoder) {
		
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		
		return provider;
		
		
	}

	

}
