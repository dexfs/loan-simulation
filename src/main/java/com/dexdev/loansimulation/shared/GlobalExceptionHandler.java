package com.dexdev.loansimulation.shared;

import com.dexdev.loansimulation.modules.customer.exceptions.CustomerNotFoundException;
import com.dexdev.loansimulation.modules.product.exceptions.ProductNotFoundException;
import com.dexdev.loansimulation.shared.exceptions.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
