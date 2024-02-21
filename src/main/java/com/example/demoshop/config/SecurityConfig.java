package com.example.demoshop.config;

import com.example.demoshop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.example.demoshop.domain.Role.ADMIN;
import static com.example.demoshop.domain.Role.MANAGER;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService)
            throws Exception {
        http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userService)
                .passwordEncoder(bCryptPasswordEncoder);

        return http.getSharedObject(AuthenticationManager.class);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
//                        authorizationManagerRequestMatcherRegistry
                .authorizeHttpRequests((authorize) -> authorize
                                .requestMatchers("/users/new").hasAuthority(ADMIN.name())
                                .requestMatchers("/users").hasAuthority(ADMIN.name())
                                .requestMatchers("/users").hasAuthority(MANAGER.name())
                                //    .requestMatchers("/users/new").authenticated()
                                .requestMatchers("/users").permitAll()
                                .requestMatchers("/", "/login").permitAll()
                                .requestMatchers("/users/new").permitAll()
                                .requestMatchers("/products").permitAll()
                                .requestMatchers("/bucket").permitAll()
                                .requestMatchers("/auth").permitAll()
                                .requestMatchers("/logout").permitAll()
                                .anyRequest().permitAll())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                .logout(logout -> logout
                  //      .logoutUrl("/logout")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true))
                        .formLogin(Customizer.withDefaults())
                        .httpBasic(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.debug(securityDebug).ignoring().requestMatchers("/", "/users/new", "/login, /logout", "/users");
//    }
}