package com.si.controllers;


import com.si.pojo.Category;
import com.si.services.CategoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author copco
 */
@RestController
@RequestMapping("/api")
public class ApiCategoryController {
    @Autowired
    private CategoryService cateService;

    @GetMapping("/categories")
    @CrossOrigin
    public ResponseEntity<List<Category>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.cateService.getCategories(), HttpStatus.OK);
    }
}
