package gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayApplication {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p->p.path("/login_test").filters(f -> f.rewritePath("/login_test", "/session/login")).uri("lb://APP-APPLICATION"))
                .route(p->p.path("/logout_test").filters(f->f.rewritePath("/logout_test", "/session/logout")).uri("lb://APP-APPLICATION"))
                .route(p->p.path("/getInfo_test").filters(f->f.rewritePath("/getInfo_test", "/session/getInfo")).uri("lb://APP-APPLICATION"))
                //.route(p->p.path("/login").filters(f -> f.rewritePath("/login", "/bookstore/login")).uri("http://localhost:8001"))
                .route(p->p.path("/login").filters(f -> f.rewritePath("/login", "/bookstore/login")).uri("lb://APP-APPLICATION"))
                .route(p->p.path("/logout").filters(f -> f.rewritePath("/logout", "/bookstore/logout")).uri("lb://APP-APPLICATION"))
                .route(p->p.path("/getBooks").filters(f -> f.rewritePath("/getBooks", "/bookstore/getBooks")).uri("lb://APP-APPLICATION"))
                .route(p->p.path("/getBook").filters(f -> f.rewritePath("/getBook", "/bookstore/getBook")).uri("lb://APP-APPLICATION"))
                .route(p->p.path("/checkUser").filters(f -> f.rewritePath("/checkUser", "/bookstore/checkUser")).uri("lb://APP-APPLICATION"))
                .route(p->p.path("/checkSession").filters(f -> f.rewritePath("/checkSession", "/bookstore/checkSession")).uri("lb://APP-APPLICATION"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
