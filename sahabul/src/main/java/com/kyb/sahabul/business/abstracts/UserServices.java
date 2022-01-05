package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.EmailDto;
import com.kyb.sahabul.entities.dto.OnlyIdDto;
import com.kyb.sahabul.entities.dto.UserCheckDto;
import com.kyb.sahabul.entities.dto.UserDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateUserRequest;
import com.kyb.sahabul.entities.dto.updaterequest.UpdateUserRequest;

import java.util.List;

public interface UserServices {
    List<UserDto> getAll();
    User findById(int id);
    UserDto getById(OnlyIdDto id);
    UserDto add(CreateUserRequest from);
    UserDto update(UpdateUserRequest from);
    UserDto delete(int userId);
    UserDto getByEmail(EmailDto email);
    boolean checkUserIsRight(UserCheckDto from);

}
