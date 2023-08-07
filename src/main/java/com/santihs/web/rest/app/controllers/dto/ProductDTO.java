package com.santihs.web.rest.app.controllers.dto;

import com.santihs.web.rest.app.entities.Maker;
import lombok.*;

import java.math.BigDecimal;

@Value
@AllArgsConstructor
@Builder
public class ProductDTO {
  Long id;
  String name;
  BigDecimal price;
  Maker maker;
}
