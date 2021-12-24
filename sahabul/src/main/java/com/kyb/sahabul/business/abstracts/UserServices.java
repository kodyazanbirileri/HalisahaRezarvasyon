package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserDto;

import java.util.List;

public interface UserServices {
    List<UserDto> getAll();
    UserDto getById(int id);
    void add(User user);
    void deleteUser(User user);
    //TODO: DTO araştırması yapılıp, ona göre DTO üzerinden update işlemi yapılacak.
}
