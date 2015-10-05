package ru.kpfu.itis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigExample {


    @Bean
    public Guitar guitar() {
        return new Guitar();
    }

}
