package com.dexdev.loansimulation.modules.product.services;

import com.dexdev.loansimulation.modules.product.entities.Product;
import com.dexdev.loansimulation.modules.product.repositories.InMemoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListProductsService {
    @Autowired
    InMemoryProductRepository repository;


    public List<Product> execute() {
        return repository.all();
    }
}
