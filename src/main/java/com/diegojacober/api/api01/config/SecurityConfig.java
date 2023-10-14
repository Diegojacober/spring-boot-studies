package com.diegojacober.api.api01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authz) -> authz
                        // .requestMatchers(mvc.pattern("/spring-mvc-controller/**")).hasRole("USER")
                        .requestMatchers("/api/clientes/**")
                        // .permitAll()
                        .hasAnyRole("USER", "ADMIN")
                        // .hasAuthority("MANTER USUARIO")
                        .requestMatchers("/api/produtos/**").hasRole("ADMIN")
                        .requestMatchers("/api/pedidos/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(withDefaults());
        return http.build();
    }

    // autenticação em memória
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("test")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
