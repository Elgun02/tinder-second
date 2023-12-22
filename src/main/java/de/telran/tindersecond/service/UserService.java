package de.telran.tindersecond.service;

import de.telran.tindersecond.entity.User;

import java.util.List;

public interface UserService {

    User getNewUser();

    List<User> getByName(String name);

    List<User> getBetweenRating(int minRating, int maxRating);

    List<User> getByDescriptionContaining(String value);

    Boolean findUserContainingId(Long id);

    List<User> getAllUsers(Integer page, Integer size);



}
