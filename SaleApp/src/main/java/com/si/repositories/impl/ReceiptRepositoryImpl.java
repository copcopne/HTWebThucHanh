/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.si.repositories.impl;

import com.si.pojo.Cart;
import com.si.pojo.OrderDetail;
import com.si.pojo.SaleOrder;
import com.si.repositories.ReceiptRepository;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author copcopne
 */
@Repository
@Transactional
public class ReceiptRepositoryImpl implements ReceiptRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public void addReceipt(List<Cart> carts) {
        Session s = this.factory.getObject().getCurrentSession();
        if (carts != null) {
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
