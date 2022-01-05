package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.UserServices;
import com.kyb.sahabul.core.converter.UpdateToRequestUserDtoConverter;
import com.kyb.sahabul.core.converter.UserDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.UserDao;
import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserCheckDto;
import com.kyb.sahabul.entities.dto.UserDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateUserRequest;
import com.kyb.sahabul.entities.dto.updaterequest.UpdateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserServices {

    private final UserDao userDao;
    private final UserDtoConverter userDtoConverter;
    private final UpdateToRequestUserDtoConverter updateToRequestUserDtoConverter;

    public UserManager(UserDao userDao,
                       UserDtoConverter userDtoConverter,
                       UpdateToRequestUserDtoConverter updateToRequestUserDtoConverter) {
        this.userDao = userDao;
        this.userDtoConverter = userDtoConverter;
        this.updateToRequestUserDtoConverter = updateToRequestUserDtoConverter;
    }

    @Override
    public List<UserDto> getAll() {
        return userDao.findAll().
                stream().
                map(userDtoConverter::convert).
                collect(Collectors.toList());
    }

    @Override
    public User findById(int id) {
        return userDao.getOne(id);
    }

    @Override
    public UserDto getById(int id) {
        return userDtoConverter.convert(userDao.getOne(id));
    }

    private User generateBody(User user,CreateUserRequest from)
    {
        user.setFirstName(from.getFirstName());
        user.setLastName(from.getLastName());
        user.setEmail(from.getEmail());
        user.setStatus(true);
        user.setPassword(from.getPassword());
        user.setPhoneNumber(from.getPhoneNumber());
        return user;
    }


    @Override
    public UserDto add(CreateUserRequest from) {
        User tempUser = new User();
        return userDtoConverter.convert(userDao.save(generateBody(tempUser,from)));

    }

    @Override
    public UserDto update(UpdateUserRequest from) {
        User tempUser = new User();
        tempUser.setId(from.getId());

        return userDtoConverter.convert(
                userDao.save(generateBody(tempUser,
                        updateToRequestUserDtoConverter.convert(from))));
    }

    @Override
    public UserDto delete(int userId) {

        User deletedUser = this.findById(userId);
        deletedUser.setStatus(false);

        return userDtoConverter.convert(userDao.save(deletedUser));
    }

    @Override
    public UserDto getByEmail(String email) {
        return userDtoConverter.convert(userDao.getByEmail(email));
    }

    @Override
    public boolean checkUserIsRight(UserCheckDto from) {

        User targetUser = userDao.getByEmail(from.getEmail());

        if ( targetUser != null ) {
            return Objects.equals(targetUser.getPassword(), from.getPassword());
        }

        return false;
    }


}
