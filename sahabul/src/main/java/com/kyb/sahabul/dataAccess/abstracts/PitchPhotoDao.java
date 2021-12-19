package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.PitchPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PitchPhotoDao extends JpaRepository<PitchPhoto, Integer> {
}
