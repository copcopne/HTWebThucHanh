/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.si.services.impl;

import com.si.services.StatService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    private StatService statService;
    @Override
    public List<Object[]> statsRevenueByProduct() {
        return this.statService.statsRevenueByProduct();
    }

    @Override
    public List<Object[]> statsRevenueByTime(String time, int year) {
        return this.statService.statsRevenueByTime(time, year);
    }
    
}
