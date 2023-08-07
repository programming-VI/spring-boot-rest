package com.santihs.web.rest.app.controllers;

import com.santihs.web.rest.app.controllers.dto.MakerDTO;
import com.santihs.web.rest.app.services.IMakerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
@AllArgsConstructor
public class MakerController {
  private IMakerService makerService;

  @GetMapping("/{id}")
  public ResponseEntity<MakerDTO> findById(@PathVariable Long id) {
    Optional<MakerDTO> optionalMaker = makerService.findById(id);
    return optionalMaker
            .map(makerDTO -> new ResponseEntity<>(makerDTO, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @GetMapping("")
  public ResponseEntity<List<MakerDTO>> findAll() {
    List<MakerDTO> makerDTOS = makerService.findAll();
    return new ResponseEntity<>(makerDTOS, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<MakerDTO> save(@RequestBody MakerDTO makerDTO) {
    if (makerDTO.getName().isBlank()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    MakerDTO makerSaved = makerService.save(makerDTO);
    return new ResponseEntity<>(makerSaved, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<MakerDTO> updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO) {
    Optional<MakerDTO> optionalMaker = makerService.findById(id);
    if (optionalMaker.isPresent()) {
      MakerDTO maker = optionalMaker.get();
      MakerDTO makerToSave = MakerDTO.builder()
              .id(maker.getId())
              .name(makerDTO.getName())
              .products(maker.getProducts())
              .build();
      MakerDTO makerSaved = makerService.save(makerToSave);
      return new ResponseEntity<>(makerSaved, HttpStatus.OK);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteById(@PathVariable Long id) {
    if (id != null) {
      makerService.deleteById(id);
      return ResponseEntity.noContent().build();
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
