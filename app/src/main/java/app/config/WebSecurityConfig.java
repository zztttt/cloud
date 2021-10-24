package app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {
    private RedisSessionInterceptor redisSessionInterceptor;
    @Autowired
    public WebSecurityConfig(RedisSessionInterceptor redisSessionInterceptor){
        this.redisSessionInterceptor = redisSessionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(redisSessionInterceptor)
                .addPathPatterns("/session/**")
                .addPathPatterns("/bookstore/**")
                .excludePathPatterns("/session/login")
                .excludePathPatterns("/bookstore/login")
                .excludePathPatterns("/bookstore/checkSession");
        super.addInterceptors(registry);
    }

//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }

//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig());
//        return new CorsFilter(source);
//    }
}
