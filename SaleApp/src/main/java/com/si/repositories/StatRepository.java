/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.si.repositories;

import java.util.List;

/**
 *
 * @author admin
 */
public interface StatRepository {
    List<Object[]> statsRevenueByProduct();
    List<Object[]> statsRevenueByTime(String time, int year);
}
