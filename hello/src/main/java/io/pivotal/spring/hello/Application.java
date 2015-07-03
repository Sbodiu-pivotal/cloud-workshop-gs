package io.pivotal.spring.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String hello() {
        return "hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
