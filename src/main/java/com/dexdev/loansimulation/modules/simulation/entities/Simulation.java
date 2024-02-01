package com.dexdev.loansimulation.modules.simulation.entities;

import com.dexdev.loansimulation.modules.customer.entities.Customer;
import com.dexdev.loansimulation.modules.product.entities.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final int id;
    private final Customer customer;
    private final double amount;
    private final List<SimulationInstallment> installments;
    private final LocalDateTime createdAt;
    private final Product product;

    public Simulation(int id, Customer customer, double amount, Product product) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.installments = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public List<SimulationInstallment> getInstallments() {
        return installments;
    }

    public void addInstallment(SimulationInstallment installment) {
        installments.add(installment);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Product getProduct() {
        return product;
    }


    @Override
    public String toString() {
        return "Simulation{" +
                "id=" + id +
                ", clientId=" + customer +
                ", total=" + amount +
                ", instalments=" + installments +
                ", createdAt=" + createdAt +
                ", product=" + product +
                '}';
    }
}
