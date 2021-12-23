package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.UserService;
import com.kyb.sahabul.core.converter.UserDtoConverter;
import com.kyb.sahabul.dataAccess.abstracts.UserDao;
import com.kyb.sahabul.entities.concretes.User;
import com.kyb.sahabul.entities.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {

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
    public UserDto getById(int id) {
        userDtoConverter.convert(userDao.getOne(id));
        return null;
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);

    }


}
