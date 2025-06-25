/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.si.saledemo;

import com.si.repositories.impl.CategoryRepositoryImpl;
import com.si.repositories.impl.ProductRepositoryImpl;
import com.si.repositories.impl.StatRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class SaleDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCates().forEach(c -> System.out.println(c.getName()));
//        ProductRepositoryImpl s = new ProductRepositoryImpl();
//        Map<String, String> params = new HashMap<>();
//        params.put("fromPrice", "28000000");
//        params.put("page", "1");
//        s.getProducts(params).forEach(p -> 
//                System.out.printf("%d: %s - %.1f\n", p.getId(), 
//                        p.getName(), p.getPrice()));
//        
StatRepositoryImpl s = new StatRepositoryImpl();
//s.statsRevenueByProduct().forEach(o -> System.out.printf("%d: %s - %d\n", o[0], o[1], o[2]));
s.statsRevenueByTime("MONTH", 2020).forEach(o -> System.out.printf("%s - %d\n", o[0], o[1]));
    }
}
