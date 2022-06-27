package com.anubhabnath.learn.users;

import com.anubhabnath.learn.users.models.User;
import com.anubhabnath.learn.users.models.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class InMemoryRepository implements IUserRepository {
    private List<User> users = new ArrayList<>();
    // HashMap can be used instead?

    @Override
    public User createUser(UserDto userDto) {
        User user = User.with(userDto, UUID.randomUUID());
        users.add(user);
        return user;
    }

    @Override
    public User getUser(UUID id) {
        for(User user: users) {
            if(id.equals(user.getId()))
                return user;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void updateUser(UUID id, UserDto userDto) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)) {
                users.set(i, User.with(userDto, id));
                return;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void deleteUser(UUID id) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)) {
                users.remove(i);
                return;
            }
        }
        throw new NoSuchElementException();
    }
}
