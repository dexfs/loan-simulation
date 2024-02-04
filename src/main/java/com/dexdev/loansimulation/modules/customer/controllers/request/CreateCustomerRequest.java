package com.dexdev.loansimulation.modules.customer.controllers.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class CreateCustomerRequest {

    @NotBlank
    public String name;

    @NotNull(message = "The date of birth is required")
    @Past(message = "The date of birth must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate birthDate;
    @NotBlank
    public String ssn;
    @NotBlank
    public String ssnType;
}
