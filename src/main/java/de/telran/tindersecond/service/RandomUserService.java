package de.telran.tindersecond.service;

import de.telran.tindersecond.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service //то же, что и component, но более явно указывает, что это именно сервис
public class RandomUserService implements UserService {

    @Override
    public User getNewUser() {
        List<User> users = new ArrayList<>();
        User firstUser = new User(1, "Petr", 100, "Просто Петр");
        User secondUser = new User(2, "Anna", 150, "Люблю щенков");
        User thirdUser = new User(3, "Pavel", 200, "Ненавижу щенков");

        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);

        Random random = new Random();

        int randomNumber = random.nextInt(3);

        return users.get(randomNumber);
    }

}
