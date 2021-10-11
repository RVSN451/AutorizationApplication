package com.example.Autorization.config;

import com.example.Autorization.AutorizationApplication;
import com.example.Autorization.controller.AuthorizationController;
import com.example.Autorization.repository.AuthorizationRepository;
import com.example.Autorization.service.AuthorizationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JavaConfig {
   /* @Bean
    public AuthorizationController controller(AuthorizationService service) {
        return new AuthorizationController(service);
    }

    @Bean
    public AuthorizationService service(AuthorizationRepository repository) {
        return new AuthorizationService(repository);
    }

    @Bean
    public AuthorizationRepository repository() {
        return new AuthorizationRepository();
    }
*/
    @SpringBootApplication
    public static class AutorizationApplication {

        public static void main(String[] args) {
            SpringApplication.run(com.example.Autorization.AutorizationApplication.class, args);
        }

    }
}


