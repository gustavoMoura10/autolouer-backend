package com.autolouer.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autolouer.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @RequestMapping(method = { RequestMethod.GET })
    public List<User> getUser() {
        List<User> userLists = new ArrayList<>();
        userLists.add(new User(Long.valueOf(1), "Gustavo", "Moura", new Timestamp(0), "GustavoMoura", "123456"));
        userLists.add(new User(Long.valueOf(2), "Manoel", "Gomes", new Timestamp(0), "ManoelGomes", "123456"));
        return userLists;
    }

}
