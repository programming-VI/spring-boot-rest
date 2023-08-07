package com.santihs.web.rest.app.repository;

import com.santihs.web.rest.app.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//! CrudRepository uses the table, and the id <Maker, Long>
@Repository
public interface MakerRepository extends CrudRepository<Maker, Long> {
}
