/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.si.services;

import com.si.pojo.User;

/**
 *
 * @author admin
 */
public interface UserService {
    User getUserByUsername(String username);
}
