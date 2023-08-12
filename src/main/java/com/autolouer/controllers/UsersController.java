package com.autolouer.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autolouer.entities.defaultapp.Users;
import com.autolouer.services.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService userService;

    @RequestMapping(value = "/{id}", method = { RequestMethod.GET })
    public ResponseEntity<Users> getUser(@PathVariable Integer id) {
        Users user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok().body(user);
        }

    }

}
