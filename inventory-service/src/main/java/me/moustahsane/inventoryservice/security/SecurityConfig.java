package me.moustahsane.inventoryservice.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    final private JwtAuthConverter jwtAuthConverter;

    public SecurityConfig(JwtAuthConverter jwtAuthConverter) {
        this.jwtAuthConverter = jwtAuthConverter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

    return httpSecurity
            .cors(Customizer.withDefaults())
            .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
            .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()))
            .authorizeHttpRequests(ar->ar.requestMatchers("/h2-console/**").permitAll())
            .authorizeHttpRequests(ar->ar.requestMatchers("/**").authenticated())
           //.authorizeHttpRequests(ar->ar.requestMatchers("/**").permitAll())
            .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer -> httpSecurityOAuth2ResourceServerConfigurer.jwt(jwt->jwt.jwtAuthenticationConverter(jwtAuthConverter)))
            .build();
}

    @Bean
    CorsConfigurationSource corsConfigurationSource(){

    CorsConfiguration corsConfiguration = new CorsConfiguration();

    corsConfiguration.setAllowedHeaders(List.of("*"));
    corsConfiguration.setAllowedMethods(List.of("*"));
    corsConfiguration.setAllowedOrigins(List.of("*"));
    corsConfiguration.setExposedHeaders(List.of("*"));

    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

    return urlBasedCorsConfigurationSource;
}
}
