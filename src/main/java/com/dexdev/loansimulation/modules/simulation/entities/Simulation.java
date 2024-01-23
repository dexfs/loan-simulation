package com.dexdev.loansimulation.modules.simulation.entities;

import java.util.Date;

public class Simulation {
    private int id;
    private int clientId;
    private int amount;
    private int instalments;
    private Date createdAt;
    private int productId;

    public Simulation(int id, int clientId, int amount, int instalments, Date createdAt, int productId) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.instalments = instalments;
        this.createdAt = createdAt;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInstalments() {
        return instalments;
    }

    public void setInstalments(int instalments) {
        this.instalments = instalments;
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
                ", amount=" + amount +
                ", instalments=" + instalments +
                ", createdAt=" + createdAt +
                ", productId=" + productId +
                '}';
    }
}
