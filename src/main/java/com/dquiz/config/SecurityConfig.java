package com.dquiz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(7));
        return provider;
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        .csrf().disable()
        .authorizeRequests()
            .requestMatchers("/quizess/", "/quizess/home", "/auth/register", "/auth/login").permitAll()
            .requestMatchers("/views/**").permitAll()
            .anyRequest().authenticated()
        .and()
        .formLogin()
            .loginPage("/quizess/login")  // Custom login page URL
            .loginProcessingUrl("/auth/login")  // URL for form submission processing
            .defaultSuccessUrl("/quizess/home", true)  // Redirect after successful login
            .failureUrl("/auth/login?error=true")  // Redirect on login failure
            .permitAll()
        .and()
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);



        return http.build();
    }
}

