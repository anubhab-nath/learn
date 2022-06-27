package com.anubhabnath.learn.users;

import com.anubhabnath.learn.users.models.*;

import java.util.UUID;

import static com.anubhabnath.learn.users.models.Preconditions.validateNotNull;

public class UserService implements IUserService {
    private final IUserRepository fUserRepository;

    public UserService(IUserRepository fUserRepository) {
        this.fUserRepository = fUserRepository;
    }

    @Override
    public User createUser(UserDto userDto) {
        validateNotNull(userDto);
        return fUserRepository.createUser(userDto);
    }

    @Override
    public User getUser(UUID id) {
        validateNotNull(id);
        return fUserRepository.getUser(id);
    }

    @Override
    public void updateUser(UUID id, UserDto userDto) {
        validateNotNull(id);
        validateNotNull(userDto);
        fUserRepository.updateUser(id, userDto);
    }

    @Override
    public void deleteUser(UUID id) {
        validateNotNull(id);
        fUserRepository.deleteUser(id);
    }
}
