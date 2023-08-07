package com.santihs.web.rest.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maker")
public class Maker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  //! Mapping
  //! Cascade is used when a change is done in this class, it will be applied to their products
  //! fetch is useful to recover the list when it is necessary
  //! Orphan Removal: remove all maker list when a maker is deleted
  @OneToMany(mappedBy = "maker", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JsonIgnore
  private List<Product> products;
}
