package com.anubhabnath.learn.users.models;

public class Preconditions {
    public static void validateNotNull(Object field) {
        if(field == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePhoneNumber(String phone) {
        if(!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateEmail(String email) {
        if(!email.matches("^([\\w-.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$")) {
            throw new IllegalArgumentException();
        }
    }
}
