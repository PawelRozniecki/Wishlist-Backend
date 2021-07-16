package com.pwr.AngularSpring.Store.repositories;

import com.pwr.AngularSpring.Store.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
