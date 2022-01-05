package com.kyb.sahabul.dataAccess.abstracts;

import com.kyb.sahabul.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
