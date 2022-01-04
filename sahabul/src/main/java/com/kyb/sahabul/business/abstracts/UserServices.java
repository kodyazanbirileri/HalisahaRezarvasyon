package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateUserRequest;

import java.util.List;

public interface UserServices {
    List<UserDto> getAll();
    User findById(int id);
    UserDto getById(int id);
    UserDto add(CreateUserRequest createUserRequest);
    void deleteUser(User user);
    //TODO: DTO araştırması yapılıp, ona göre DTO üzerinden update işlemi yapılacak.
}
