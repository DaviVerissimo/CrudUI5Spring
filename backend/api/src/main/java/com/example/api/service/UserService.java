package com.example.api.service;

import com.example.api.repository.UserRepository;
import com.example.api.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(
            UserRepository repository
    ) {
        this.repository = repository;
    }

    public List<User> list() {

        return repository.findAll();

    }

    public User findById(Long id) {

        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Usuário não encontrado."
                        ));

    }

    public User save(
            User user
    ) {

        user.setId(null);

        return repository.save(user);

    }

    public User update(
            Long id,
            User user
    ) {

        User existingUser  =
                findById(id);

        existingUser .setName(
                user.getName()
        );

        existingUser .setEmail(
                user.getEmail()
        );

        return repository.save(
                existingUser
        );

    }

    public void delete(Long id) {

        repository.deleteById(id);

    }

}
