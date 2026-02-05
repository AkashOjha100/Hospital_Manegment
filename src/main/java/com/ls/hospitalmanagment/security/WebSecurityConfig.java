package com.ls.hospitalmanagment.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFillter jwtAuthFillter;
    //private final PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(csrfConfig ->csrfConfig.disable())
                .sessionManagement(sessionConfig ->
                        sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth->auth
                        //.requestMatchers("/admin/**").authenticated()
                        .requestMatchers("/public/**","/auth/**").permitAll()
                        .anyRequest().authenticated())
                        //.requestMatchers("/doctors/**").hasAnyRole("DOCTOR","ADMIN"))
                //.formLogin(Customizer.withDefaults());
                .addFilterBefore(jwtAuthFillter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
