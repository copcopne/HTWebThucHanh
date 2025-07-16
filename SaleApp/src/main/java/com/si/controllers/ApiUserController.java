/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.si.controllers;

import com.si.pojo.User;
import com.si.services.UserService;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author copco
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {
    
    private UserService userService;
    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestParam Map<String, String> params, 
            @RequestParam(name = "avatar") MultipartFile avatar) {
        User u = this.userService.addUser(params, avatar);
        
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }
}
