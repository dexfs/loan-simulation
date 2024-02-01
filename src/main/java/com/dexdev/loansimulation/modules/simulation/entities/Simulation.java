package com.dexdev.loansimulation.modules.simulation.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Simulation {
    private int id;
    private int clientId;
    private double amount;
    private final List<SimulationInstallment> installments;
    private Date createdAt;
    private int productId;

    public Simulation(int id, int clientId, int amount, int productId) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.installments = new ArrayList<>();
        this.createdAt = new Date();
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<SimulationInstallment> getInstallments() {
        return installments;
    }

    public void addInstallment(SimulationInstallment installment) {
        installments.add(installment);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Simulation{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", total=" + amount +
                ", instalments=" + installments +
                ", createdAt=" + createdAt +
                ", productId=" + productId +
                '}';
    }
}
