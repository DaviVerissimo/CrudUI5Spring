package com.example.api.controller;

import com.example.api.model.User;
import com.example.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UserService service;

    public UsuarioController(
            UserService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<User> listar() {

        return List.of(
                new User(1L, "João Silva", "joao@email.com"),
                new User(2L, "Maria Santos", "maria@email.com"),
                new User(3L, "Pedro Oliveira", "pedro@email.com"),
                new User(4L, "Ana Costa", "ana@email.com")
        );
    }

        @GetMapping("/{id}")
        public User findById(
                @PathVariable Long id
        ) {

            return service.findById(id);

        }

        @PostMapping
        public User save(
                @RequestBody User user
        ) {

            return service.save(user);

        }

        @PutMapping("/{id}")
        public User update(
                @PathVariable Long id,
                @RequestBody User user
        ) {

            return service.update(
                    id,
                    user
            );

        }

        @DeleteMapping("/{id}")
        public void delete(
                @PathVariable Long id
        ) {

            service.delete(id);

        }

    }



