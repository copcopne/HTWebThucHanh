/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.si.repositories.impl;

import com.si.pojo.Cart;
import com.si.pojo.OrderDetail;
import com.si.pojo.SaleOrder;
import com.si.saledemo.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author copcopne
 */
public class ReceiptRepositoryImpl {
    public void addReceipt(List<Cart> carts) {
        if (carts != null) {
            try (Session s = HibernateUtils.getFACTORY().openSession()) {
            SaleOrder order = new SaleOrder();
            order.setUserId(new UserRepositoryImpl().getUserByUsername("dhthanh"));
            order.setCreatedDate(new Date());
            s.persist(order);
            for (var x: carts) {
                OrderDetail d = new OrderDetail();
                d.setQuantity(x.getQuantity());
                d.setUnitPrice(x.getPrice());
                d.setProductId(new ProductRepositoryImpl().getProductById(x.getId()));
                d.setOrderId(order);
                s.persist(d);
            }
            }
        }
    }
}
