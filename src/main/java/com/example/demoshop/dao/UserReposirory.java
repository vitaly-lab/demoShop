package com.example.demoshop.dao;

import com.example.demoshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposirory extends JpaRepository<User, Long> {
    User findFirstByName(String name);
}
