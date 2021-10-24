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
                .route(p->p.path("/login_test").filters(f -> f.rewritePath("/login_test", "/session/login")).uri("http://localhost:8002"))
                .route(p->p.path("/logout_test").filters(f->f.rewritePath("/logout_test", "/session/logout")).uri("http://localhost:8002"))
                .route(p->p.path("/getInfo_test").filters(f->f.rewritePath("/getInfo_test", "/session/getInfo")).uri("http://localhost:8002"))
                .route(p->p.path("/login").filters(f -> f.rewritePath("/login", "/bookstore/login")).uri("http://localhost:8002"))
                .route(p->p.path("/logout").filters(f -> f.rewritePath("/logout", "/bookstore/logout")).uri("http://localhost:8002"))
                .route(p->p.path("/getBooks").filters(f -> f.rewritePath("/getBooks", "/bookstore/getBooks")).uri("http://localhost:8002"))
                .route(p->p.path("/getBook").filters(f -> f.rewritePath("/getBook", "/bookstore/getBook")).uri("http://localhost:8002"))
                .route(p->p.path("/checkUser").filters(f -> f.rewritePath("/checkUser", "/bookstore/checkUser")).uri("http://localhost:8002"))
                .route(p->p.path("/checkSession").filters(f -> f.rewritePath("/checkSession", "/bookstore/checkSession")).uri("http://localhost:8002"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
