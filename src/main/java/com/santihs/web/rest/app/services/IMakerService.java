package com.santihs.web.rest.app.services;

import com.santihs.web.rest.app.controllers.dto.MakerDTO;

import java.util.List;
import java.util.Optional;

public interface IMakerService {
  Optional<MakerDTO> findById(Long id);

  List<MakerDTO> findAll();

  MakerDTO save(MakerDTO maker);

  void deleteById(Long id);
}
