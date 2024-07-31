package com.soumya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
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
	public SpringSecurityConfig(UserDetailsService userDetailsService) {
		
		this.userDetailsService = userDetailsService;
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		 http
         .authorizeHttpRequests((requests) ->  requests
             .requestMatchers(HttpMethod.GET,"/students").permitAll().
              requestMatchers(HttpMethod.POST,"/students").authenticated().
              anyRequest().authenticated()
         
         )
         .formLogin(Customizer.withDefaults())
         .logout((logout) -> logout
             .permitAll()
         );
		 
		 http.csrf(csrf -> csrf.disable() );
		 
		 http.httpBasic(Customizer.withDefaults());		 
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
