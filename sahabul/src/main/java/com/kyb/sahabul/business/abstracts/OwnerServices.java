package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.Owner;

public interface OwnerServices {
    Owner getById();
    void addOwner(Owner owner);
    void deleteOwner(Owner owner);
    // TODO: DTO araştırması yapılıp, ona göre DTO üzerinden update işlemi yapılacak.
}
