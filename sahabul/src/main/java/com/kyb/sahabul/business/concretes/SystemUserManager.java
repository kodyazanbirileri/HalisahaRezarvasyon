package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.SystemUserService;
import com.kyb.sahabul.core.converter.SystemUserDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.SystemUserDao;
import com.kyb.sahabul.entities.concretes.SystemUser;
import com.kyb.sahabul.entities.dto.SystemUserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemUserManager implements SystemUserService {
    private final SystemUserDao systemUserDao;
    private final SystemUserDtoConverter systemUserDtoConverter;

    public SystemUserManager(SystemUserDao systemUserDao, SystemUserDtoConverter systemUserDtoConverter) {
        this.systemUserDao = systemUserDao;
        this.systemUserDtoConverter = systemUserDtoConverter;
    }


    @Override
    public List<SystemUserDto> getAll() {
        return systemUserDao.findAll().stream()
                .map(systemUserDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public SystemUserDto getById(int id) {
        return systemUserDtoConverter.convert(systemUserDao.getOne(id));
    }

    @Override
    public SystemUserDto add(SystemUser systemUser) {
        return systemUserDtoConverter.convert(systemUserDao.save(systemUser));
    }

    @Override
    public void deleteOwner(SystemUser systemUser) {
        systemUserDao.delete(systemUser);
        //TODO: Veritabanından silmek yerine pasif hale getirilebilir.
    }
}
