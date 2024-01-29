package com.dexdev.loansimulation.modules.customer.controllers.validations;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class CreateCustomerRequest implements Serializable {

    @NotBlank
    public String name;
    @NotBlank
    public String birthDate;
    @NotBlank
    public String ssn;
    @NotBlank
    public String ssnType;
}
