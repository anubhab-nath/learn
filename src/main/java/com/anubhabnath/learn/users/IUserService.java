package com.anubhabnath.learn.users;

import com.anubhabnath.learn.users.models.*;

import java.util.UUID;

public interface IUserService {

    /**
     *
     * @param userDto contains the necessary information for the User
     * @return the created user
     */
    User createUser(UserDto userDto);

    /**
     * @param id UserId of the user being queried.
     * @return the user object for the UserId provided.
     */
    User getUser(UUID id);

    /**
     * @param id UserId of the user to be updated
     * @param userDto New users data for update
     */
    void updateUser(UUID id, UserDto userDto);

    void deleteUser(UUID id);
}
