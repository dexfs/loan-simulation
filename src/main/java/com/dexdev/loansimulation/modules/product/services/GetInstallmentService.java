package com.dexdev.loansimulation.modules.product.services;

import com.dexdev.loansimulation.modules.product.entities.InstallmentTax;
import com.dexdev.loansimulation.modules.product.entities.Product;
import com.dexdev.loansimulation.modules.product.repositories.InMemoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetInstallmentService {
    @Autowired
    InMemoryProductRepository repository;
    public InstallmentTax execute(Integer productId, Integer installmentNumber) {
        return repository.getInstallmentByIdAndProduct(productId, installmentNumber);
    }
}
