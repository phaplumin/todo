package com.jhost.template.Template.service;

import com.jhost.template.Template.model.Task;
import com.jhost.template.Template.model.User;
import com.jhost.template.Template.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User GetTasksByUserId(long userid)
    {
        return userRepository.GetById(userid);

    }

    public long CreateUser(User user)
    {
        User createdUser = userRepository.save(user);

        return createdUser.getUserid();

    }

    public long UpdateUser(User user)
    {
        User createdUser = userRepository.save(user);

        return createdUser.getUserid();

    }

}
