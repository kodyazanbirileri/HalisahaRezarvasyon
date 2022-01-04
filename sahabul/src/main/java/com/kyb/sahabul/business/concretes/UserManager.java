package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.UserServices;
import com.kyb.sahabul.core.converter.UserDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.UserDao;
import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserDto;
import com.kyb.sahabul.entities.dto.createrequest.CreateUserRequest;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserServices {

    private final UserDao userDao;
    private final UserDtoConverter userDtoConverter;

    public UserManager(UserDao userDao, UserDtoConverter userDtoConverter) {
        this.userDao = userDao;
        this.userDtoConverter = userDtoConverter;
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

    @Override
    public UserDto add(CreateUserRequest from) {
        User tempUser = new User();

        tempUser.setFirstName(from.getFirstName());
        tempUser.setLastName(from.getLastName());
        tempUser.setEmail(from.getEmail());
        tempUser.setStatus(true);
        tempUser.setPassword(from.getPassword());
        tempUser.setPhoneNumber(from.getPhoneNumber());

        return userDtoConverter.convert(userDao.save(tempUser));

    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);

    }


}
