package com.example.demoshop.service;

import com.example.demoshop.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService { // security
    boolean save (UserDTO userDTO);
    List<UserDTO> getAll();
}
