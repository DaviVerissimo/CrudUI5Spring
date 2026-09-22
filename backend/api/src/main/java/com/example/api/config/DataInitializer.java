package com.example.api.config;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(
            UserRepository repository,
            PasswordEncoder passwordEncoder
    ) {

        return args -> {

            if (repository.findByEmail("joao@email.com").isEmpty()) {

                User user = new User(
                        null,
                        "João Silva",
                        "joao@email.com",
                        passwordEncoder.encode("123456"),
                        "USER"
                );

                repository.save(user);

                System.out.println(
                        "USUÁRIO JOÃO CRIADO COM SUCESSO"
                );
            }

            if (repository.findByEmail("admin@email.com").isEmpty()) {

                User admin = new User(
                        null,
                        "Administrador",
                        "admin@email.com",
                        passwordEncoder.encode("123456"),
                        "ADMIN"
                );

                repository.save(admin);

                System.out.println(
                        "USUÁRIO ADMIN CRIADO COM SUCESSO"
                );
            }
        };
    }
}