package com.dexdev.loansimulation.modules.customer.repositories;

import java.util.List;

public interface CustomerRepository<Type> {
    List<Type> all();
    void save(Type entity);


}
