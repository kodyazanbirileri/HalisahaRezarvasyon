package com.kyb.sahabul.business.concretes;

import com.kyb.sahabul.business.abstracts.UserService;
import com.kyb.sahabul.dataAccess.abstracts.UserDao;
import com.kyb.sahabul.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager  implements UserService {

    private UserDao userDao;

    @Autowired
    UserManager(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById() {
        return null;
    }

    @Override
    public void addUser(User user) {
        this.userDao.save(user);
    }

    @Override
    public void deleteUser(User user) {

    }
}
