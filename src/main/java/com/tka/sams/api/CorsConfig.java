package com.tka.sams.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow all endpoints
                        .allowedOrigins(
                            "https://samstrackattendance.netlify.app",
                            "http://localhost:4200"
                        )
                        .allowedMethods(
                            "GET",
                            "POST",
                            "PUT",
                            "DELETE",
                            "PATCH",
                            "OPTIONS",
                            "HEAD"
                        )
                        .allowedHeaders("*") // Accept all headers
                        .exposedHeaders("Authorization", "Content-Type") // Let browser access these response headers
                        .allowCredentials(true) // Allow cookies/token to be sent
                        .maxAge(3600); // Cache preflight request for 1 hour
            }
        };
    }
}
