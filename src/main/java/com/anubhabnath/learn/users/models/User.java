package com.anubhabnath.learn.users.models;

import java.util.UUID;

import static com.anubhabnath.learn.users.models.Preconditions.*;

public class User {
    private final UUID id;
    private final String name;
    private final String phone;
    private final String email;

    /**
     *
     * @param id userId of the user
     * @param name name of the user
     * @param phone phone number of the user
     * @param email email address of the user
     * @throws IllegalArgumentException if any of the following conditions fail:
     *          1. Phone Number: Must be 10 characters in length and all numeric.
     *          2. Email: Must contain @ in the middle of the string.
     */
    public User(UUID id, String name, String phone, String email) throws IllegalArgumentException {
        // Validations
        validateNotNull(id);
        validateNotNull(name);
        validateNotNull(phone);
        validatePhoneNumber(phone);
        validateNotNull(email);
        validateEmail(email);

        //Assignment
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public static User with(UserDto userDto, UUID userId) {
        return new User(userId, userDto.getName(), userDto.getPhone(), userDto.getEmail());
    }

    public String getEmail() {
        return email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
