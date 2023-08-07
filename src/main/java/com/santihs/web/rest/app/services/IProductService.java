package com.santihs.web.rest.app.services;

import com.santihs.web.rest.app.controllers.dto.ProductDTO;
import com.santihs.web.rest.app.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {
  Optional<ProductDTO> findById(Long id);

  List<ProductDTO> findAll();

  List<ProductDTO> findByPriceInRange(BigDecimal min, BigDecimal max);

  ProductDTO save(ProductDTO product);

  void deleteById(Long id);

}
