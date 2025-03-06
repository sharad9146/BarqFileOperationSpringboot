package com.example.BarqFileOperation.Config;

import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for API calls
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/files/upload").permitAll() // Allow file uploads without authentication
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.disable()) // Disable form login
                .httpBasic(basic -> basic.disable()); // Disable basic authentication

        return http.build();
    }
}
