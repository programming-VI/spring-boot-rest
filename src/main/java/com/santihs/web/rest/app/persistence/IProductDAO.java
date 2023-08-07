package com.santihs.web.rest.app.persistence;

import com.santihs.web.rest.app.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {
  Optional<Product> findById(Long id);

  List<Product> findAll();

  List<Product> findByPriceInRange(BigDecimal min, BigDecimal max);

  Product save(Product maker);

  void deleteById(Long id);
}
