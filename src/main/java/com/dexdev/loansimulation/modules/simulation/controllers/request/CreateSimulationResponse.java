package com.dexdev.loansimulation.modules.simulation.controllers.request;

import com.dexdev.loansimulation.modules.customer.entities.Customer;
import com.dexdev.loansimulation.modules.simulation.entities.Simulation;
import com.dexdev.loansimulation.modules.simulation.entities.SimulationInstallment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreateSimulationResponse {
    private final int id;
    private final Customer customer;
    private final double amount;
    private final List<SimulationInstallment> installments;
    private final String created_at;

    private CreateSimulationResponse(int id, Customer customer, double amount, List<SimulationInstallment> installments, LocalDateTime createdAt) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.installments = installments;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        created_at = createdAt.format(dtf);
    }

    public static CreateSimulationResponse create(Simulation simulation) {
        return new CreateSimulationResponse(
                simulation.getId(),
                simulation.getCustomer(),
                simulation.getAmount(),
                simulation.getInstallments(),
                simulation.getCreatedAt()
        );
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


    public String getCreated_at() {
        return created_at;
    }
}
