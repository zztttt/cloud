package gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p->p.path("/login").filters(f -> f.rewritePath("/login", "/session/login")).uri("http://localhost:8002"))
                .route(p->p.path("/logout").filters(f->f.rewritePath("/logout", "/session/logout")).uri("http://localhost:8002"))
                .route(p->p.path("/getInfo").filters(f->f.rewritePath("/getInfo", "/session/getInfo")).uri("http://localhost:8002"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
