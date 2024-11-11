package com.pablomonteserin.login.persistence.repository;

import com.pablomonteserin.login.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(@Param("username") String username);


}
