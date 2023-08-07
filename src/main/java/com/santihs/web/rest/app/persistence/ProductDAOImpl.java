package com.santihs.web.rest.app.persistence;

import com.santihs.web.rest.app.entities.Product;
import com.santihs.web.rest.app.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements IProductDAO {

  private ProductRepository productRepository;

  public ProductDAOImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public List<Product> findAll() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  public List<Product> findByPriceInRange(BigDecimal min, BigDecimal max) {
    return productRepository.findProductsByPriceBetween(min, max);
  }

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }
}
