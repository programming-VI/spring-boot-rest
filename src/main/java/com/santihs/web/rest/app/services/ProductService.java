package com.santihs.web.rest.app.services;

import com.santihs.web.rest.app.controllers.dto.ProductDTO;
import com.santihs.web.rest.app.entities.Product;
import com.santihs.web.rest.app.persistence.IProductDAO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

  private IProductDAO productDAO;

  public ProductService(IProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  @Override
  public Optional<ProductDTO> findById(Long id) {
    Optional<Product> optionalProduct = productDAO.findById(id);
    return optionalProduct.map(this::buildProductDTO);
  }

  @Override
  public List<ProductDTO> findAll() {
    return productDAO.findAll().stream()
            .map(this::buildProductDTO)
            .collect(Collectors.toList());
  }

  @Override
  public List<ProductDTO> findByPriceInRange(BigDecimal min, BigDecimal max) {
    return productDAO.findByPriceInRange(min, max).stream()
            .map(this::buildProductDTO)
            .collect(Collectors.toList());
  }

  @Override
  public ProductDTO save(ProductDTO productDTO) {
    Product product = buildProduct(productDTO);
    var productSaved = productDAO.save(product);
    return buildProductDTO(productSaved);
  }

  @Override
  public void deleteById(Long id) {
    productDAO.deleteById(id);
  }

  private ProductDTO buildProductDTO(Product product) {
    return ProductDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice())
            .maker(product.getMaker())
            .build();
  }

  private Product buildProduct(ProductDTO productDTO) {
    return Product.builder()
            .id(productDTO.getId())
            .name(productDTO.getName())
            .price(productDTO.getPrice())
            .maker(productDTO.getMaker())
            .build();
  }
}
