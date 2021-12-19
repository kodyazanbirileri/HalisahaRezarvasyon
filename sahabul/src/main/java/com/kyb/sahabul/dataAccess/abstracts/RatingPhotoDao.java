package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.RatingPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingPhotoDao extends JpaRepository<RatingPhoto, Integer> {
}
