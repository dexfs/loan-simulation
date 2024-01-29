package com.dexdev.loansimulation.modules.product.controllers;

import com.dexdev.loansimulation.modules.product.entities.Product;
import com.dexdev.loansimulation.modules.product.services.GetInstallmentService;
import com.dexdev.loansimulation.modules.product.services.ListProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ListProductsService listProductsService;

    @Autowired
    GetInstallmentService getInstallmentService;



    @GetMapping
    public List<Product> all() {
        return listProductsService.execute();

    }
}
