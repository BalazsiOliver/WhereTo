package com.DragonFart.WhereTo.ChatPart.service;

import com.DragonFart.WhereTo.ChatPart.model.Users;
import com.DragonFart.WhereTo.ChatPart.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){

        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
