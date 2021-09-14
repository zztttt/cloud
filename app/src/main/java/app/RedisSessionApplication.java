package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RedisSessionApplication {
    @GetMapping("/app/get")
    public String hello(){
        return "hello, zzt";
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisSessionApplication.class, args);
    }
}
