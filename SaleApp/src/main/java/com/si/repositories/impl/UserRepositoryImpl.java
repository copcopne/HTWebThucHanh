///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.si.repositories.impl;
//
//import com.si.pojo.User;
//import com.si.saledemo.HibernateUtils;
//import jakarta.persistence.Query;
//import org.hibernate.Session;
//
///**
// *
// * @author copcopne
// */
//public class UserRepositoryImpl {
//    public User getUserByUsername(String username) {
//        try (Session s = HibernateUtils.getFACTORY().openSession()) {
//            Query q = s.createNamedQuery("User.findByUsername", User.class);
//            q.setParameter("username", username);
//            
//            return (User) q.getSingleResult();
//        }
//    }
//}
