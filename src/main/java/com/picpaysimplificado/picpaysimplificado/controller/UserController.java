package com.picpaysimplificado.picpaysimplificado.controller;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.picpaysimplificado.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Post que cria os usuários
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) { // Com o @RequestBody o Spring injeta em user o corpo da requisição

        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    // Get para buscar todos os usuários cadastrados
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get para buscar um usuário em específico
    @GetMapping("{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) throws Exception {
        User user = this.userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

}
