package com.santihs.web.rest.app.controllers.dto;

import com.santihs.web.rest.app.entities.Product;
import lombok.*;

import java.util.List;

@Value
@AllArgsConstructor
@Builder
public class MakerDTO {
  Long id;
  String name;
  List<Product> products;
}
