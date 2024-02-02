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
                        new InstallmentTax(1, 25),
                        new InstallmentTax(2, 37.1f),
                        new InstallmentTax(3, 37.1f),
                        new InstallmentTax(4, 39),
                        new InstallmentTax(5, 39),
                        new InstallmentTax(6, 39),
                        new InstallmentTax(7, 39),
                        new InstallmentTax(8, 39),
                        new InstallmentTax(9, 39),
                        new InstallmentTax(10, 39),
                        new InstallmentTax(11, 39),
                        new InstallmentTax(12, 39)
                );

        product.setTaxes(taxes);
        products.add(product);
    }

    public List<Product> all() {
        return products;
    }

    public Optional<Product> getById(int productId) {
        return products.stream()
                .filter(p -> p.getId() == productId)
                .findFirst();
    }

    public InstallmentTax getInstallmentByIdAndProduct(Integer productId, Integer installment) {
        Optional<Product> foundProduct = products
                .stream()
                .filter(p -> p.getId() == productId)
                .findFirst();

        return foundProduct
                .flatMap(product -> product.getTaxes().stream().filter(t -> t.getNumber() == installment).findFirst())
                .orElse(null);
    }

    public List<InstallmentTax> getInstallmentsByProductIdAndQuantity(Integer productId, Integer numberOf) {
        Product foundProduct = products
                .stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElseThrow();

        return foundProduct.getTaxes().stream().limit(numberOf).toList();
    }
}
