package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.SystemUser;
import com.kyb.sahabul.entities.dto.SystemUserDto;

import java.util.List;

public interface SystemUserServices {
    List<SystemUserDto> getAll();
    SystemUserDto getById(int id);
    SystemUserDto add(SystemUser systemUser);
    void deleteOwner(SystemUser systemUser);
}
