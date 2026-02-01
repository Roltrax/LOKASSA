package com.project.DBManage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.DBManage.repositories.IUserRepository;
import com.project.DBManage.models.UserModel;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    // Get
    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Post
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    // Put
    public UserModel updateById(UserModel request, Long id) {
        UserModel user = userRepository.findById(id).get();
        user.setNombre(request.getNombre());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setTelefono(request.getTelefono());
        user.setRol(request.getRol());
        user.setFechaCreacion(request.getFechaCreacion());
        return userRepository.save(user);
    }

    // Delete
    public String deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return "Usuario eliminado";
        } catch (Exception e) {
            return "Usuario no eliminado";
        }
    }
}
