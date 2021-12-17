package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerDao extends JpaRepository<Owner, Integer> {

}
