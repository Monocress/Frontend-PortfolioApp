package com.dorukt.repository;

import com.dorukt.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsernameAndPassword(String username, String password);
}
