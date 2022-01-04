package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.SystemUser;
import com.kyb.sahabul.entities.dto.SystemUserDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateSystemUserRequest;

import java.util.List;

public interface SystemUserServices {
    List<SystemUserDto> getAll();
    SystemUserDto getById(int id);
    SystemUserDto add(CreateSystemUserRequest createSystemUserRequest);
    void deleteOwner(SystemUser systemUser);
}
