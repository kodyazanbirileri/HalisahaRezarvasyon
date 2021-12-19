package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityDao extends JpaRepository<City, Integer> {
}
