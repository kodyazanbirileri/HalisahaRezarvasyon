package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.OwnerServices;
import com.kyb.sahabul.entities.concretes.Owner;
import org.springframework.stereotype.Service;

@Service
public class OwnerManager implements OwnerServices {
    @Override
    public Owner getById() {
        return null;
    }

    @Override
    public void addOwner(Owner owner) {

    }

    @Override
    public void deleteOwner(Owner owner) {

    }
}
