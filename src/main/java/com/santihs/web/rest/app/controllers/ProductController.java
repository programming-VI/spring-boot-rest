package com.santihs.web.rest.app.controllers;

import com.santihs.web.rest.app.controllers.dto.ProductDTO;
import com.santihs.web.rest.app.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/api/product")
public class ProductController {
  private IProductService productService;

  @GetMapping("/{id}")
  public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
    Optional<ProductDTO> optional = productService.findById(id);
    return optional.map(productDTO -> new ResponseEntity<>(productDTO, HttpStatus.OK))
            .orElseGet(() -> ResponseEntity.internalServerError().build());
  }

  @GetMapping("")
  public ResponseEntity<List<ProductDTO>> findAll() {
    var list = productService.findAll();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
    if (productDTO.getName().isBlank() || productDTO.getPrice() == null
            || productDTO.getMaker() == null) {
      return ResponseEntity.badRequest().build();
    }
    var productSaved = productService.save(productDTO);
    return new ResponseEntity<>(productSaved, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
    var optionalProduct = productService.findById(id);
    if (optionalProduct.isPresent()) {
      ProductDTO product = optionalProduct.get();
      ProductDTO productToSave = ProductDTO.builder()
              .id(product.getId())
              .name(productDTO.getName())
              .price(productDTO.getPrice())
              .maker(productDTO.getMaker())
              .build();
      ProductDTO productSaved = productService.save(productToSave);
      return ResponseEntity.ok(productSaved);
    }
    return ResponseEntity.notFound().build();
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable Long id) {
    if (id == null) {
      return ResponseEntity.badRequest().build();
    }
    productService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
