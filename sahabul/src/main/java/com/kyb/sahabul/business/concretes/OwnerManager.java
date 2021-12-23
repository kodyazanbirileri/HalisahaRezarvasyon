package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.OwnerServices;
import com.kyb.sahabul.core.converter.OwnerDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.OwnerDao;
import com.kyb.sahabul.entities.concretes.Owner;
import com.kyb.sahabul.entities.dto.OwnerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerManager implements OwnerServices {

    private final OwnerDao ownerDao;
    private final OwnerDtoConverter ownerDtoConverter;

    public OwnerManager(OwnerDao ownerDao, OwnerDtoConverter ownerDtoConverter) {
        this.ownerDao = ownerDao;
        this.ownerDtoConverter = ownerDtoConverter;
    }

    @Override
    public List<OwnerDto> getAll() {
        return ownerDao.findAll().stream()
                .map(ownerDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDto getById(int id) {

        return ownerDtoConverter.convert(ownerDao.getOne(id));
    }

    @Override
    public OwnerDto add(Owner owner) {
        return ownerDtoConverter.convert(ownerDao.save(owner));
    }

    @Override
    public void delete(Owner owner) {
        ownerDao.delete(owner);

    }
}
