package com.autolouer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autolouer.entities.defaultapp.Users;
import com.autolouer.repositories.UsersRepository;

@Service
public class UsersService {
    @Autowired
    private UsersRepository userRepository;

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
