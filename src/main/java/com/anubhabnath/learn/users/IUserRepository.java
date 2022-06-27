package com.anubhabnath.learn.users;

import com.anubhabnath.learn.users.models.User;
import com.anubhabnath.learn.users.models.UserDto;

import java.util.UUID;

public interface IUserRepository {
    User createUser(UserDto userDto);

    User getUser(UUID id);

    void updateUser(UUID id, UserDto userDto);

    void deleteUser(UUID id);
}
