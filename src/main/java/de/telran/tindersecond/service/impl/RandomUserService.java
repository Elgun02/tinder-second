package de.telran.tindersecond.service.impl;

import de.telran.tindersecond.entity.User;
import de.telran.tindersecond.repository.UserRepository;
import de.telran.tindersecond.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service // Component, но более явно указывает, что это именно сервис
@RequiredArgsConstructor
public class RandomUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getNewUser() {
        List<User> users = userRepository.findAll();

        if (users == null || users.size() == 0) {
            throw new RuntimeException();
        }

        Random random = new Random();

        int randomNumber = random.nextInt(3);

        return users.get(randomNumber);
    }

    @Override
    public List<User> getByName(String name) {
        return null;
    }

    @Override
    public List<User> getBetweenRating(int minRating, int maxRating) {
        return null;
    }

    @Override
    public List<User> getByDescriptionContaining(String value) {
        return null;
    }

    @Override
    public Boolean findUserContainingId(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers(Integer page, Integer size) {
        return null;
    }

}
