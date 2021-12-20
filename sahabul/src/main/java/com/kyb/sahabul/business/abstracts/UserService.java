package com.kyb.sahabul.business.abstracts;

import com.kyb.sahabul.entities.concretes.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById();
    void addUser(User user);
    void deleteUser(User user);
    //TODO: DTO araştırması yapılıp, ona göre DTO üzerinden update işlemi yapılacak.
}
