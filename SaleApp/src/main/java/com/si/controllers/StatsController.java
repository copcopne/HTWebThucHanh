/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.si.controllers;

import com.si.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author copco
 */
@Controller
public class StatsController {
    @Autowired
    public StatsService statsService;
    
    @GetMapping("/stats")
    public String stats(Model model){
        model.addAttribute("productRevenues", statsService.statsRevenueByProduct());
        
        return "stats";
    }
}
