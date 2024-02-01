package com.dexdev.loansimulation.modules.simulation.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final int id;
    private final int clientId;
    private final double amount;
    private final List<SimulationInstallment> installments;
    private final LocalDateTime createdAt;
    private final int productId;

    public Simulation(int id, int clientId, int amount, int productId) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.installments = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
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

    public int getProductId() {
        return productId;
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
