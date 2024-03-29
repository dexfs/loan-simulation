package com.dexdev.loansimulation.modules.product.entities;

import java.io.Serializable;
import java.util.List;


public class Product implements Serializable  {
    private int id;
    private String name;

    private List<InstallmentTax> taxes;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<InstallmentTax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<InstallmentTax> taxes) {
        this.taxes = taxes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
