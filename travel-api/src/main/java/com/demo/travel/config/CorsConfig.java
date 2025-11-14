package com.demo.travel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry r) {
    r.addMapping("/**")
     .allowedOriginPatterns(
        "http://localhost:5173",
        "https://*.travel-project-rho-woad.vercel.app/"
     )
     .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
     .allowedHeaders("*")
     .allowCredentials(false);
  }
}