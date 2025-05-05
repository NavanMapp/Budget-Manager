package com.mapp.budgetmanager.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration implements WebMvcConfigurer {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors().and()
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().permitAll()
                );
        return http.build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOrigins("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedOrigins("*");
    }

//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        MappingJackson2CborHttpMessageConverter converter = new MappingJackson2CborHttpMessageConverter();
//        converter.setSupportedMediaTypes(List.of(MediaType.APPLICATION_JSON));
//        converters.add(converter);
//    }
}
