package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.ComplainedRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainedRatingDao extends JpaRepository<ComplainedRating,Integer> {
}
