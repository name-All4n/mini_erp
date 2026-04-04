package com.my_project.mini_ERP.repository;

import com.my_project.mini_ERP.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
}
