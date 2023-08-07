package com.santihs.web.rest.app.persistence;

import com.santihs.web.rest.app.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {
  Optional<Maker> findById(Long id);

  List<Maker> findAll();

  Maker save(Maker maker);

  void deleteById(Long id);
}
