package com.dexdev.loansimulation.modules.simulation.controllers.dtos;

import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import com.dexdev.loansimulation.modules.simulation.entities.SimulationInstallment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreateSimulationResponse {
    private final int id;
    private final int clientId;
    private final double amount;
    private final List<SimulationInstallment> installments;
    private final int productId;
    private final String created_at;

    private CreateSimulationResponse(int id, int clientId, double amount, List<SimulationInstallment> installments, LocalDateTime createdAt, int productId) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.installments = installments;
        this.productId = productId;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        created_at = createdAt.format(dtf);
    }

    public static CreateSimulationResponse create(Simulation simulation) {
        return new CreateSimulationResponse(
                simulation.getId(),
                simulation.getClientId(),
                simulation.getAmount(),
                simulation.getInstallments(),
                simulation.getCreatedAt(),
                simulation.getProductId()
        );
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

    public int getProductId() {
        return productId;
    }

    public String getCreated_at() {
        return created_at;
    }
}
