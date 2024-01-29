package com.dexdev.loansimulation.modules.product.services;

import com.dexdev.loansimulation.modules.product.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ListProductsServicesTests {
    @Autowired
    ListProductsService listProductsService;
    @Test
    void testLoadProduct() {
        List<Product> products = listProductsService.execute();
        Assertions.assertEquals(products.size(), 1);
    }
}
