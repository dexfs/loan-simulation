package com.dexdev.loansimulation.modules.product.services;

import com.dexdev.loansimulation.modules.product.entities.InstallmentTax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetInstallmentServiceTest {
    @Autowired
    GetInstallmentService service;

    @Test
    void testGetInstallmentNumber3() {
        InstallmentTax installmentTax = service.execute(1, 3);

        Assertions.assertNotNull(installmentTax);
        Assertions.assertEquals(installmentTax.getNumber(), 3);
        Assertions.assertEquals(installmentTax.getValue(), 5);
    }
}
