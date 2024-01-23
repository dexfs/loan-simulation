package com.dexdev.loansimulation.modules.product.controllers;

import com.dexdev.loansimulation.modules.product.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> all() {
        return List.of(new Product(1, "SALVATION"));
    }
}
