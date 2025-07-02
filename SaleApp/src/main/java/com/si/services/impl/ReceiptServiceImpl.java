/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.si.services.impl;

import com.si.pojo.Cart;
import com.si.repositories.ReceiptRepository;
import com.si.services.ReceiptService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {
    private ReceiptRepository receiptRepo;

    @Override
    public void addReceipt(List<Cart> carts) {
        this.receiptRepo.addReceipt(carts);
    }
    
}
