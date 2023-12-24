package de.telran.tindersecond.service.impl;

import de.telran.tindersecond.entity.Photo;
import de.telran.tindersecond.entity.User;
import de.telran.tindersecond.repository.PhotoRepository;
import de.telran.tindersecond.repository.UserRepository;
import de.telran.tindersecond.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
@RequiredArgsConstructor
public class TopRatingUserService implements UserService {

    private final UserRepository userRepository;
    private final PhotoRepository photoRepository;

    @Override
    public User getNewUser() {
        List<User> users = userRepository.findAll();

        int maxRating = 0;
        User bestUser = null;

        for (User user : users) {
            if (user.getRating() > maxRating) {
                maxRating = user.getRating();
                bestUser = user;
            }
        }

        return bestUser;
    }

    @Override
    public List<User> getByName(String name) {
        List<User> users = userRepository.getUsersByNameStartingWithIgnoreCase(name);
        List<Photo> photos = photoRepository.findAll();
        System.out.println(photos);
        return users;
    }

    // Homework
    // Задача 1.
    @Override
    public List<User> getBetweenRating(int minRating, int maxRating) {
        List<User> users = userRepository.getUsersBetweenRating(minRating, maxRating);
        if (users == null || users.isEmpty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    // Задача 2.
    @Override
    public List<User> getByDescriptionContaining(String value) {
        List<User> users = userRepository.getUsersByDescriptionContain(value);
        if (users == null || users.isEmpty()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return users;
    }

    // Задача 3.
    @Override
    public Boolean findUserContainingId(Long id) {
        User user = userRepository.findUserById(id);

        if (user != null && user.getId().equals(id)) {
            return true;
        }

        return false;
    }

    // Задача 4. (2 уровень сложности)
    @Override
    public List<User> getAllUsers(Integer page, Integer size) {

        if (page < 1 || size < 1) {
            try {
                throw new IllegalAccessException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        int offset = (page - 1) * size;

        return userRepository.getAllUsers(offset, size);
    }
}
