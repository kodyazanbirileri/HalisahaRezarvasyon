package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.SystemUserServices;
import com.kyb.sahabul.business.abstracts.UserServices;
import com.kyb.sahabul.core.converter.SystemUserDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.SystemUserDao;
import com.kyb.sahabul.entities.concretes.SystemUser;
import com.kyb.sahabul.entities.dto.SystemUserDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateSystemUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemUserManager implements SystemUserServices {
    private final SystemUserDao systemUserDao;
    private final SystemUserDtoConverter systemUserDtoConverter;
    private final UserServices userServices;

    public SystemUserManager(SystemUserDao systemUserDao, SystemUserDtoConverter systemUserDtoConverter, UserServices userServices) {
        this.systemUserDao = systemUserDao;
        this.systemUserDtoConverter = systemUserDtoConverter;
        this.userServices = userServices;
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
    public SystemUserDto add(CreateSystemUserRequest from) {
        SystemUser tempSystemUser = new SystemUser();

        tempSystemUser.setUser(userServices.findById(from.getUserId()));
        return systemUserDtoConverter.convert(systemUserDao.save(tempSystemUser));
    }

    @Override
    public void deleteOwner(SystemUser systemUser) {
        systemUserDao.delete(systemUser);
        //TODO: Veritabanından silmek yerine pasif hale getirilebilir.
    }
}
