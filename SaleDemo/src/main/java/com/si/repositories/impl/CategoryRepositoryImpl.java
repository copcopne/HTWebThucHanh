/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.si.repositories.impl;

import com.si.pojo.Category;
import com.si.saledemo.HibernateUtils;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class CategoryRepositoryImpl {
    public List<Category> getCates() {
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            Query q = s.createQuery("FROM Category", Category.class);
            return q.getResultList();
        }
    }
}
