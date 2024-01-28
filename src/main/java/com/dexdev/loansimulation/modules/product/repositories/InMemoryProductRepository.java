package com.dexdev.loansimulation.modules.product.repositories;

import com.dexdev.loansimulation.modules.product.entities.InstallmentTax;
import com.dexdev.loansimulation.modules.product.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public InMemoryProductRepository() {
        Product product = new Product(1, "EasyMoney");
        List<InstallmentTax> taxes = Arrays
                .asList(
                new InstallmentTax(1, 10f),
                new InstallmentTax(2, 10f),
                new InstallmentTax(3, 5f),
                new InstallmentTax(4, 2.5f)
        );

        product.setTaxes(taxes);
        products.add(product);
    }

    public List<Product> all() {
        return products;
    }

    public InstallmentTax getInstallmentByIdAndProduct(Integer productId, Integer installment) {
        Product foundProduct = products.get(productId-1);
        return foundProduct.getTaxes().get(installment-1);
    }
}
