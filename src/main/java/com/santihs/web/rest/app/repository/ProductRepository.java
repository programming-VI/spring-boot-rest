package com.santihs.web.rest.app.repository;

import com.santihs.web.rest.app.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
  //! JPA know how to do, QUERY METHODS
  List<Product> findProductsByPriceBetween(BigDecimal min, BigDecimal max);

  //! This way doesn't exist in JPA, it is necessary to create the query
  //! This language is called JPQL, QUERY ANNOTATION
  //?  @Query("select p from Product p where p.price >= ?1 and p.price <= ?2")
  @Query("select p from Product p where p.price between ?1 and ?2")
  List<Product> findProductsByPriceInRange(BigDecimal min, BigDecimal max);
}
