package lesson24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ConsolerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsolerApplication.class, args);
    }
}
