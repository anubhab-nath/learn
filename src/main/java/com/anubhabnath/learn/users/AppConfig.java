package com.anubhabnath.learn.users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    IUserRepository configureUserRepository() {
        return new InMemoryRepository();
    }

    @Bean
    IUserService configureUserService(IUserRepository fUserRepository) {
        return new UserService(fUserRepository);
    }
}
