package com.project.DBManage.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.project.DBManage.services.UserService;
import com.project.DBManage.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET: todos los usuarios
    @GetMapping
    public ArrayList<UserModel> getAllUsers() {
        return userService.getUsers();
    }

    // GET: usuario por id
    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // POST: crear usuario
    @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    // PUT: actualizar usuario
    @PutMapping("/{id}")
    public UserModel updateUser(@RequestBody UserModel request, @PathVariable Long id) {
        return userService.updateById(request, id);
    }

    // DELETE: eliminar usuario
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}

