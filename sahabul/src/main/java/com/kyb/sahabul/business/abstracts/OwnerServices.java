package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Owner;
import com.kyb.sahabul.entities.dto.OwnerDto;

import java.util.List;

public interface OwnerServices {
    List<OwnerDto> getAll();
    OwnerDto getById(int id);
    OwnerDto add(Owner owner);
    void delete(Owner owner);
    // TODO: DTO araştırması yapılıp, ona göre DTO üzerinden update işlemi yapılacak.
}
