package com.santihs.web.rest.app.services;

import com.santihs.web.rest.app.controllers.dto.MakerDTO;
import com.santihs.web.rest.app.entities.Maker;
import com.santihs.web.rest.app.persistence.IMakerDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MakerServiceImpl implements IMakerService {
  private IMakerDAO makerDAO;

  public MakerServiceImpl(IMakerDAO makerDAO) {
    this.makerDAO = makerDAO;
  }

  @Override
  public Optional<MakerDTO> findById(Long id) {
    var maker = makerDAO.findById(id);
    return maker.map(this::buildMakerDTO);
  }

  @Override
  public List<MakerDTO> findAll() {
    return makerDAO.findAll().stream()
            .map(this::buildMakerDTO)
            .collect(Collectors.toList());
  }

  @Override
  public MakerDTO save(MakerDTO makerDTO) {
    Maker makerBuilt = buildMaker(makerDTO);
    var makerSaved = makerDAO.save(makerBuilt);
    return buildMakerDTO(makerSaved);
  }

  @Override
  public void deleteById(Long id) {
    makerDAO.deleteById(id);
  }

  private MakerDTO buildMakerDTO(Maker maker) {
    return MakerDTO.builder()
            .id(maker.getId())
            .name(maker.getName())
            .products(maker.getProducts())
            .build();
  }

  private Maker buildMaker(MakerDTO makerDTO) {
    return Maker.builder()
            .id(makerDTO.getId())
            .name(makerDTO.getName())
            .products(makerDTO.getProducts())
            .build();
  }
}
