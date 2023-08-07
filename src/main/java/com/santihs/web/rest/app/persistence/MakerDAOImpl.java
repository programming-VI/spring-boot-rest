package com.santihs.web.rest.app.persistence;

import com.santihs.web.rest.app.entities.Maker;
import com.santihs.web.rest.app.repository.MakerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

  MakerRepository makerRepository;

  public MakerDAOImpl(MakerRepository makerRepository) {
    this.makerRepository = makerRepository;
  }

  @Override
  public Optional<Maker> findById(Long id) {
    return makerRepository.findById(id);
  }

  @Override
  public List<Maker> findAll() {
    return (List<Maker>) makerRepository.findAll();
  }

  @Override
  public Maker save(Maker maker) {
    return makerRepository.save(maker);
  }

  @Override
  public void deleteById(Long id) {
    makerRepository.deleteById(id);
  }
}
