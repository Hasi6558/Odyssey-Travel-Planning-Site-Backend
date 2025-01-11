package com.example.OdysseyTravelPlanningWebsiteBackendApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("https://Hasi6558.github.io") // Allow requests only from your GitHub Pages site
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Allow specific HTTP methods
    }
}
