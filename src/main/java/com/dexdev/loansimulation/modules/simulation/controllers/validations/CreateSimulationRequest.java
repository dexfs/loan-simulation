package com.dexdev.loansimulation.modules.simulation.controllers.validations;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class CreateSimulationRequest implements Serializable {
    @NotNull
    public Integer clientId;
    @NotNull
    @Min(1000)
    public Integer amount;
    @NotNull
    @Min(1)
    @Max(12)
    public Integer installments;

}
