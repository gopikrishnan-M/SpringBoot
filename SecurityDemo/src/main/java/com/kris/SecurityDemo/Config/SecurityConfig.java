package com.kris.SecurityDemo.Config;

import jakarta.servlet.annotation.WebServlet;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFltrChn(HttpSecurity httpSecurity) throws Exception{
        /*httpSecurity.csrf(customiser -> customiser.disable());
        httpSecurity.authorizeHttpRequests( request ->
                request.anyRequest()
                        .authenticated());
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();*/
        // instead of writing like above writing a method and keeping dot ...
        // finally building it is known as builder pattern
        return httpSecurity
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests( request ->request
                                .requestMatchers("/login","/register")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


   /* @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User
                .withDefaultPasswordEncoder()
                .username("janani")
                .password("gopi")
                .roles("MANAGER")
                .build();
        UserDetails user2= User
                        .withDefaultPasswordEncoder()
                        .username("gopi")
                        .password("janani")
                        .roles("ADMIN")
                        .build();


        return new InMemoryUserDetailsManager(user1,user2);
    }*/

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
//tat return statement containing row throws an exception  instead of adding
// it in method this annotation is recommende by intelij
    @SneakyThrows
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config){
        return config.getAuthenticationManager();
    }
}
